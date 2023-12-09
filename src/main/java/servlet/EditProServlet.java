package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.Load;

/**
 * Servlet implementation class EditProServlet
 */
@WebServlet("/EditProServlet")
public class EditProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProServlet() {
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
		String id = request.getParameter("eid");
		String name = request.getParameter("ename");
		String img = request.getParameter("eimg");
		String price = request.getParameter("eprice");
		String des = request.getParameter("edes");
		String cate = request.getParameter("ecate");
		
		Load load = new Load();

		load.editProduct(id, name, price, des, cate,img);
		
		getServletContext().getRequestDispatcher("/admin/manage?loai=product").forward(request, response);
	}

}
