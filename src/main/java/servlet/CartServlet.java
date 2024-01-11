package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.Load;
import models.BillProduct;
import models.Product;
import models.User;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/product/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String maSP = request.getParameter("maSP");
			String soLuong = request.getParameter("quantity");
			Product sp = Load.mapProduct.get(maSP);
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("cart");
			double price = 0;
			int totalP = 1;
			double totalMoney = 0;
			int sizeCart = 0;
			double total = 0;
			String action = request.getParameter("action"); // gọi tới dữ liệu có tên là action
			System.out.println(action);

			User user = (User) session.getAttribute("user");
			if (user == null) {
				response.sendRedirect("/login.jsp");
				return;
			}
			if (action.equals("Them")) {
				// nếu chưa có session cart
				if (obj == null) {
					try {
						totalP = Integer.parseInt(soLuong);
					} catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					totalMoney = sp.getPrice() * totalP;
					BillProduct billProduct = new BillProduct(maSP, sp.getpName(), sp.getPrice(), totalP, totalMoney, sp.getImg());

					Map<String, BillProduct> mapCart = new HashMap<String, BillProduct>();
					mapCart.put(maSP, billProduct);
					sizeCart = mapCart.size();
					session.setAttribute("cart", mapCart);
					session.setAttribute("total", billProduct.getTotal());
				} else {
					Map<String, BillProduct> mapCart = (Map<String, BillProduct>) obj;
					BillProduct billProduct = mapCart.get(maSP);


					// chưa có sản phẩm đó trong giỏ hàng
					if(billProduct==null) {
						try {
							totalP = Integer.parseInt(soLuong);
						} catch (Exception e) {
							// TODO: handle exception
							e.getMessage();
						}
						totalMoney = sp.getPrice() * totalP;
						System.out.println(totalMoney);
						billProduct = new  BillProduct(maSP, sp.getpName(),sp.getPrice(),totalP, totalMoney, sp.getImg());
						System.out.println(billProduct.toString());
						mapCart.put(maSP, billProduct);
					}else { // đã có sản phẩm đó trong giỏ hàng
						try {
							totalP = Integer.parseInt(soLuong) + billProduct.getQuantity();
						} catch (Exception e) {
							// TODO: handle exception
							e.getMessage();
						}
						totalMoney = sp.getPrice() * totalP;

						billProduct.setQuantity(totalP);
						billProduct.setTotal(totalMoney);
					}
					for (BillProduct b : mapCart.values()) {
						total+= b.getTotal();
					}
					sizeCart = mapCart.size();
					for(BillProduct i : mapCart.values()){
						System.out.println("m"+ i.toString());
					}

					session.setAttribute("cart", mapCart);
					session.setAttribute("total", total);
				}
				session.setAttribute("sizeCart", sizeCart);
				getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);
			}else
			if(action.equals("Xoa")) {
				Map<String, BillProduct> mapCart = (Map<String, BillProduct>)obj;
				mapCart.remove(maSP);
				session.setAttribute("cart", mapCart);
				sizeCart = mapCart.size();
				session.setAttribute("sizeCart", sizeCart);
				getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);
			}else
			if (action.equalsIgnoreCase("Update")) {
				String newQuantity = request.getParameter("quantity");
				int newQuantityValue;

				try {
					newQuantityValue = Integer.parseInt(newQuantity);

					// Check if the new quantity is a non-negative value
					if (newQuantityValue <= 0) {
						// Display an error message
						request.setAttribute("errorMessage", "Số lượng không hợp lệ!");
						getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);
						return; // Stop further processing
					}
				} catch (NumberFormatException e) {
					// Handle the case where the new quantity is not a valid integer
					request.setAttribute("errorMessage", "Invalid quantity format");
					getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);
					return; // Stop further processing
				}

				// Continue with the rest of the update logic
				Map<String, BillProduct> mapCart = (Map<String, BillProduct>) obj;
				BillProduct billProduct = mapCart.get(maSP);

				// Update the quantity and total only if the new quantity is valid
				totalP = newQuantityValue;
				totalMoney = billProduct.getPrice() * totalP;

				billProduct.setQuantity(totalP);
				billProduct.setTotal(totalMoney);

				// Calculate the new total for the entire cart
				total = 0;
				for (BillProduct b : mapCart.values()) {
					total += b.getTotal();
				}

				sizeCart = mapCart.size();
				session.setAttribute("cart", mapCart);
				session.setAttribute("total", total);
				session.setAttribute("sizeCart", sizeCart);
				getServletContext().getRequestDispatcher("/product/cart.jsp").forward(request, response);;
			}
		}catch (Exception e){
			e.printStackTrace();
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
