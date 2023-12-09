package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.Load;
import conn.ViewDAO;
import models.Product;
import models.User;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User tk = (User) session.getAttribute("user");
		String pID = request.getParameter("pid");

		if (tk == null){
			request.setAttribute("pID", pID);
			response.sendRedirect("./login.jsp");
		} else {
			Load load = new Load();
			Product pro = load.getProductById(pID);
			ViewDAO viewDAO = new ViewDAO();
			try {
				viewDAO.getViewCount(pID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("detail", pro);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
