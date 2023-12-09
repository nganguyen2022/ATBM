package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.AccountDAO;
import conn.Load;
import models.User;

/**
 * Servlet implementation class EditProServlet
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("uName");
        String upassword = request.getParameter("upass");
        String rePass = request.getParameter("rePass");
        String fullName = request.getParameter("fName");
        String phone = request.getParameter("telephone");
        String email = request.getParameter("uEmail");
        String address = request.getParameter("uAddress");
        int isUser = Integer.parseInt(request.getParameter("role"));

        if (!rePass.equals(upassword)){
            request.setAttribute("error", "Mật khẩu không khớp.");
        }

        AccountDAO acc = new AccountDAO();

        acc.editUser(fullName, userName, email, phone, address, upassword, isUser);

        getServletContext().getRequestDispatcher("/admin/manage?loai=user").forward(request, response);
    }

}
