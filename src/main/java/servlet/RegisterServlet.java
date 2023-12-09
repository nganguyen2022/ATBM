package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.Load;
import models.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		if(!pass.equals(repass)) {
			request.setAttribute("mess", "Mật khẩu bạn nhập không khớp!");
			response.sendRedirect("register.jsp");
		}else {
			Load load = new Load();
			User u = load.checkUser(uname);
			request.setAttribute("userexit", "Tài khoản đã tồn tại!");
			if( u == null) {
				load.register(full_name, uname, email, phone, address, pass, publicKey, privateKey);
				response.sendRedirect("ProductServlet");
			}else {
				response.sendRedirect("register.jsp");
			}
		}
	}

}
