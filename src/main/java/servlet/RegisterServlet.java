package servlet;

import conn.Load;
import models.EncryptPass;
import models.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String full_name = request.getParameter("full_name");
		String uname = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String publicKey = request.getParameter("publicKey");
		String privateKey = request.getParameter("privateKey");

		if (!pass.equals(repass)) {
			request.setAttribute("mess", "Mật khẩu bạn nhập không khớp!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			Load load = new Load();
			User u = load.checkUser(uname);
			if (u == null) {
				try {
					pass = EncryptPass.toSHA1(pass);
					load.register(full_name, uname, email, phone, address, pass, publicKey, privateKey);


					// Chuyển hướng hoặc trả về thông báo đăng ký thành công
					response.sendRedirect("login.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("mess", "An error occurred during registration.");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("userexit", "Tài khoản đã tồn tại!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
}
