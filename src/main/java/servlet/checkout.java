package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 try {
			 HttpSession session = request.getSession();
			 String fee = "20";
			 double feeInt = Double.parseDouble(fee);
			 session.setAttribute("fee", feeInt);

			 double tong = (double) session.getAttribute("total");
			 double tongS = tong + feeInt;
			 session.setAttribute("fullPrice", tongS);

			 String privateKeyError = (String) request.getAttribute("privateKeyError");
			 if (privateKeyError != null && !privateKeyError.isEmpty()) {
				 request.setAttribute("privateKeyError", privateKeyError);
			 }
			 getServletContext().getRequestDispatcher("/product/checkout.jsp").forward(request, response);
		 }catch (Exception e ){
			 e.getStackTrace();
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
