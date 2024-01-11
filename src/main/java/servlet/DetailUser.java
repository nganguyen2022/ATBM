package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.OrderDAO;
import models.OrderProduct;
import models.User;

@WebServlet("/DetailUser")
public class DetailUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DetailUser() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User tk = (User) session.getAttribute("user");
            response.setCharacterEncoding("UTF-8");

            // Kiểm tra xem tk có null hay không
            if (tk != null) {
                OrderDAO dhDAO = new OrderDAO();
                List<OrderProduct> dh = dhDAO.top5DonHang(tk.getUname());
                request.setAttribute("donHang", dh);
                System.out.println("Đơn hàng : " + dh);

                request.getRequestDispatcher("/product/my-account.jsp").forward(request, response);
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
