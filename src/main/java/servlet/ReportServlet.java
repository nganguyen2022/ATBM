package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.OrderDAO;
import conn.ReportDAO;
import models.OrderProduct;
import models.Report;
import models.User;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User tk = (User) session.getAttribute("user");
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            // Kiểm tra xem tk có null hay không
            if (tk != null) {
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String description = request.getParameter("description");
            String time = String.valueOf(LocalDateTime.now());

            // Kiểm tra các trường dữ liệu
            if (fullName == null || fullName.isEmpty()) {
                request.setAttribute("errName", "Vui lòng nhập họ và tên");
                request.getRequestDispatcher("/product/report.jsp").forward(request, response);
                return;
            }

            if (email == null || email.isEmpty()) {
                request.setAttribute("errEmail", "Vui lòng nhập email");
                request.getRequestDispatcher("/product/report.jsp").forward(request, response);
                return;
            }

            if (phone == null || phone.isEmpty()) {
                request.setAttribute("errPhone", "Vui lòng nhập số điện thoại");
                request.getRequestDispatcher("/product/report.jsp").forward(request, response);
                return;
            }

            if (phone.length() > 10){
                request.setAttribute("err", "Vui lòng nhập đúng định dạng số điện thoại");
                request.getRequestDispatcher("/product/report.jsp").forward(request, response);
                return;
            }

            if (description == null || description.isEmpty()) {
                request.setAttribute("errDes", "Vui lòng nhập nội dung yêu cầu");
                request.getRequestDispatcher("/product/report.jsp").forward(request, response);
                return;
            }

            ReportDAO dao = new ReportDAO();
            Report r = new Report(time, fullName, email, phone, description, 1);

            String userName = tk.getUname();
            dao.add(r, userName);

            request.getRequestDispatcher("/DetailUser").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
