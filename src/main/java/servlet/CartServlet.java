package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.Load;
import models.Cart;
import models.Item;
import models.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		
		ServletContext sc = getServletContext();
		
		//get current action
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "cart"; // default action
		}
		
		//perform action and set URL to appropriate page
		String url = "/index.jsp";
		if(action.equals("shop")) {
			url = "/index.jsp";
		}else {
			if(action.equals("cart")) {
				String productCode = request.getParameter("productCode");
				String quan = request.getParameter("quantity");
				
				HttpSession session = request.getSession();
				Cart cart = (Cart) session.getAttribute("cart");
				if(cart == null) {
					cart = new Cart();
				}
				 //if the user enters a negative or invalid quantity,
	            //the quantity is automatically reset to 1.
				int quantity;
				try {
					quantity = Integer.parseInt(quan);
					if(quantity<0) {
						quantity = 1;
					}
				}catch(NumberFormatException nfe) {
					quantity = 1;
				}
				
				Load load = new Load();
				Product product = load.getProductById(productCode);
				
				Item item = new Item();
				item.setProduct(product);
				item.setQuantity(quantity);
				
				if(quantity > 0) {
					cart.addItem(item);
				}else {
					if(quantity ==0) {
						cart.removeItem(item);
					}
				}
				
				session.setAttribute("cart", cart);
				url = "/shoppingcart.jsp";
			}
			else {
				if(action.equals("checkout")) {
					url = "/checkout.jsp";
				}
			}
		}
		sc.getRequestDispatcher(url).forward(request, response);
	}

}
