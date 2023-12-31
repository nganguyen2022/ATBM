package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.AccountDAO;
import conn.Load;
import models.Keys;
import models.User;

/**
 * Servlet implementation class AddProServlet
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        AccountDAO acc = new AccountDAO();

        String userName = request.getParameter("userName");
        String upassword = request.getParameter("upassword");
        String repass = request.getParameter("repass");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String publicKey = request.getParameter("publicKey");
        String isUserParam = request.getParameter("isUser");
        Timestamp time = new Timestamp(System.currentTimeMillis());
        String date_time = String.valueOf(time);
        int isUser = 1;
        if (isUserParam != null && !isUserParam.isEmpty()) {
            isUser = Integer.parseInt(isUserParam);
        }

        User user = new User(fullName, userName, email, phone, address, upassword, isUser);
        Keys key = new Keys(userName, publicKey, date_time, 1);
        acc.add(user, key);
        request.getRequestDispatcher("/admin/manage?loai=user").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
