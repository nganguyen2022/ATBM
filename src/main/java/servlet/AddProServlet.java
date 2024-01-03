package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.Load;
import models.Category;

/**
 * Servlet implementation class AddProServlet
 */
@WebServlet("/AddProServlet")
public class AddProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProServlet() {
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
		Load load = new Load();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String img = request.getParameter("img");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String cate = request.getParameter("cate");

		List<Category> listC = load.getAllCategory();
		// set data to jsp
		request.setAttribute("listCat", listC);

		load.insertProduct(id, name, price, description, cate,img);
		request.getRequestDispatcher("/admin/manage?loai=product").forward(request, response);
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
