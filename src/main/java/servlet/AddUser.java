package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.AccountDAO;
import conn.Load;
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
        String privateKey = request.getParameter("privateKey");
        String isUserParam = request.getParameter("isUser");
        int isUser = 1;
        if (isUserParam != null && !isUserParam.isEmpty()) {
            isUser = Integer.parseInt(isUserParam);
        }

        User user = new User(fullName, userName, email, phone, address, upassword, publicKey, privateKey, isUser);
        acc.add(user);
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
