package servlet;

import conn.DetailOrderDAO;
import conn.Load;
import conn.OrderDAO;
import models.BillProduct;
import models.DetailOrder;
import models.OrderProduct;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DetailOder
 */
@WebServlet("/product/DetailOder")
public class DetailOder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailOder() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String maDH = request.getParameter("maDH");
			OrderProduct orderProduct = new OrderDAO().mapDonHang.get(maDH) ;
			DetailOrderDAO ds = new DetailOrderDAO();

			List<DetailOrder> listDS = ds.dsDHByMaDH(maDH);
			Load spDAO = new Load();
			List<Product> listSP = spDAO.getSanPhamByDH(listDS);
			System.out.println("B"+listSP);
			List<BillProduct> listBill = new ArrayList<BillProduct>();

			for (DetailOrder d : listDS) {
				Product s = spDAO.mapProduct.get(d.getIdP());

				double productReduced = s.getPrice();

				System.out.println("gia" + productReduced);
				BillProduct bill = new BillProduct(s.getpID(), s.getpName(), productReduced,d.getAmount(),d.getPrice(),s.getImg());
				listBill.add(bill);
			}

			request.setAttribute("orderProduct", orderProduct);
			request.setAttribute("listBill", listBill);
			request.getRequestDispatcher("/product/DetailOder.jsp").forward(request, response);
		}catch (Exception e){
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
