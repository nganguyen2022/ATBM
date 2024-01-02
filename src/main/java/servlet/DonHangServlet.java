package servlet;

import conn.AccountDAO;
import conn.DetailOrderDAO;
import conn.OrderDAO;
import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class DonHang
 */
@WebServlet("/DonHang")
public class DonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param date 
     * @param string2 
     * @param string 
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			User tk = (User) session.getAttribute("user");
			System.out.println(tk.toString());

			Keys puk = AccountDAO.getKeyByUser(tk.getUname());
			System.out.println(puk.toString());

			RSAKey rsa = new RSAKey();
			String fName= request.getParameter("Firstname");
			String telephone = request.getParameter("telephone");
			String note = request.getParameter("note");
			String id = request.getParameter("idOrder");
			String dateDeliveryOder = request.getParameter("dateDeliveryOder");
			String addressOder = request.getParameter("addressOder");
			String addressDetail = request.getParameter("address-details");
			String privateKey = request.getParameter("prikey");

//kiem tra privatekey voi pulickey co phai cung 1 bo khoa khong
			if(puk !=null && !rsa.areKeyPairsMatching(privateKey,puk.getPublicKey())){
				response.getWriter().println("Private key không hợp lệ");
			}
			addressOder = addressDetail + ","+ addressOder;
			Map<String, BillProduct> ds = (Map<String, BillProduct>) session.getAttribute("cart");
			double tong = (double) session.getAttribute("fullPrice");
			String tongS = String.valueOf(tong);

			if(fName==null) fName = tk.getUname();
			if(telephone==null) telephone = tk.getPhone();

			String date = String.valueOf(java.time.LocalDate.now());
			List<DetailOrder> dos = new ArrayList<>();
			for (BillProduct product : ds.values()) {

				DetailOrder ds_dh = new DetailOrder(id, product.getIdP(), product.getQuantity(), product.getTotal());
				dos.add(ds_dh);
				new DetailOrderDAO().add(ds_dh);
			}
			OrderProduct dh = new OrderProduct(id, tk.getFullName(), date,dateDeliveryOder, tongS, telephone, fName, addressOder, note,"0", "0","");
			String dataInitSignature = dh.getDataInitSignature(dos);
			String ck = new RSAKey().sign(dataInitSignature, privateKey);
			//tao chu ky moi
			dh.setSignature(ck);
			new OrderDAO().add(dh);
			session.removeAttribute("sizeCart");
			session.removeAttribute("cart");
			request.getRequestDispatcher("/ProductServlet").forward(request, response);

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
