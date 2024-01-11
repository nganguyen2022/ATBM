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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			User tk = (User) session.getAttribute("user");
			System.out.println(tk.toString());

			Keys puk = AccountDAO.getKeyByUser(tk.getUname());
			List<Keys> puk0 = AccountDAO.getKey0ByUser(tk.getUname());
			System.out.println(puk.toString());

			OrderDAO orderDAO = new OrderDAO();

			RSAKey rsa = new RSAKey();
			String fName= request.getParameter("Firstname");
			String telephone = request.getParameter("telephone");
			String note = request.getParameter("note");
			String id = request.getParameter("idOrder");
			String dateDeliveryOder = request.getParameter("dateDeliveryOder");
			String addressOder = request.getParameter("addressOder");
			String addressDetail = request.getParameter("address-details");
			String privateKey = request.getParameter("prikey");
			AccountDAO acc = new AccountDAO();
			String pub = acc.getTimePublicKey(tk.getUname());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime newKeyTime = LocalDateTime.parse(pub, format);

			// goi pthuc areKeyPairsMatching kiem tra privatekey voi pulickey
			// co phai cung 1 bo khoa khong

			addressOder = addressDetail + ","+ addressOder;
			Map<String, BillProduct> ds = (Map<String, BillProduct>) session.getAttribute("cart");
			double tong = (double) session.getAttribute("fullPrice");
			String tongS = String.valueOf(tong);

			if(fName==null) fName = tk.getUname();
			if(telephone==null) telephone = tk.getPhone();

			LocalDateTime date = LocalDateTime.now();
			String dateTime = date.format(format);

			List<DetailOrder> dos = new ArrayList<>();
			for (BillProduct product : ds.values()) {

				DetailOrder ds_dh = new DetailOrder(id, product.getIdP(), product.getQuantity(), product.getTotal());
				dos.add(ds_dh);
				new DetailOrderDAO().add(ds_dh);
			}

			OrderProduct dh = new OrderProduct();

			if(puk !=null && !rsa.areKeyPairsMatching(privateKey,puk.getPublicKey())){
				request.setAttribute("privateKeyError", "Sai private key");

				request.getRequestDispatcher("/checkout").forward(request, response);
			}
			for (Keys pubs : puk0) {
				int row = acc.countStatus0(tk.getUname());
				for (int i = 0; i < row; i++) {
					if (date.isAfter(newKeyTime) && rsa.areKeyPairsMatching(privateKey, pubs.getPublicKey())) {
						dh = new OrderProduct(id, tk.getUname(), dateTime, dateDeliveryOder, tongS, telephone, fName, addressOder, note, "0", "-2", "");
						response.getWriter().println("Đơn hàng không được xác nhận do ký bằng private cũ");
					}
				}
			}
			if (date.isAfter(newKeyTime) && rsa.areKeyPairsMatching(privateKey, puk.getPublicKey())) {
				dh = new OrderProduct(id, tk.getUname(), dateTime, dateDeliveryOder, tongS, telephone, fName, addressOder, note, "0", "0", "");
			}
      
			// Thêm đoạn mã xử lý trạng thái thanh toán
			String paymentMethod = request.getParameter("paymentMethod");
			if (paymentMethod != null && !paymentMethod.isEmpty()) {
				dh.setCheckout(paymentMethod);
			}
			// Chuyển đổi giá trị String thành int trước khi lưu vào cơ sở dữ liệu
			int checkoutInt = "online".equals(paymentMethod) ? 1 : 0;
			dh.setCheckout(String.valueOf(checkoutInt));
			// Cập nhật trạng thái thanh toán trong CSDL
//			orderDAO.add(dh);

			//goi getDataInitSignature lấy du lieu dẻ tao ký
			String dataInitSignature = dh.getDataInitSignature(dos);
			//goi ham sign tao ký va luu vao database
			String ck = new RSAKey().sign(dataInitSignature, privateKey);
			dh.setSignature(ck);

			orderDAO.add(dh);
			System.out.println(dh);

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
