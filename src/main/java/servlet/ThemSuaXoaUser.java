//package servlet;
//
//
//
//import conn.AccountDAO;
//import conn.Connect;
//import models.User;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////import dao.AccountDAO;
////import dao.LogDAO;
////import model.ConnectToDatabase;
////import model.Account;
////import model.Log;
////import util.EncryptionPass;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/ThemSuaXoaUser")
//public class ThemSuaXoaUser extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public ThemSuaXoaUser() {
//		super();
//
//	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String chucNang = request.getParameter("chucNang");
//		HttpSession session = request.getSession();
//		User tkLogin = (User) session.getAttribute("userLogin");
//		String src = request.getHeader("Referer");
//		Map<String, String> erorr = new HashMap<String, String>();
//		// set Tiếng Việt cho serverlet
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		// kiểm tra chức năng
//		// lấy dữ liệu
//		System.out.println("chucNang " +chucNang);
//		AccountDAO tk = new AccountDAO();
//		if(chucNang==null) {
//			chucNang="Them";
//		}
//		String a = request.getParameter("action");
//		System.out.println(a);
//		//Xóa
//		if(chucNang.equals("Xoa")) {
//			chucNang = request.getParameter("chucNang");
//			String userName = request.getParameter("userName");
//			System.out.println(userName);
////			Log log = new Log(Log.DANGER,tkLogin.getNameAcc(),src,"Delete: " + tk.mapAccount.get(id).toString(),1);
////			new LogDAO().add(log,request);
//			new AccountDAO().delete(userName);
//			System.out.println(tk.mapAccount);
//			request.setAttribute("tkAdmin", tk.mapAccount);
//			getServletContext().getRequestDispatcher("/admin/manage?loai=user").forward(request, response);
//		}
//		//Thêm
//		if(chucNang.equals("Them")) {
//			boolean isOk = true;
//			String tenTaiKhoan = request.getParameter("userName");
//			String matKhau = request.getParameter("passWord");
//			String reMatKhau = request.getParameter("rePassWord");
//
//			Connect con = new Connect();
//			try {
//				String query = "select * from USERS";
//				Connection connect = new Connect().getconnecttion();
//				Statement stmt =  connect.createStatement();
//				ResultSet rs=	stmt.executeQuery(query);
//				while (rs.next()) {
//					if(rs.getString(2).equals(tenTaiKhoan)) {
//						erorr.put("duplicateUserName", "Tài khoản đã tồn tại");
//						isOk =false;
//					}
//
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(tenTaiKhoan== null || tenTaiKhoan.equals("")) {
//				erorr.put("NoUserName", "Trường này không được bỏ trống");
//				isOk =false;
//			}
//			if(matKhau== null || matKhau.equals("")) {
//				erorr.put("NoPass", "Trường này không được bỏ trống");
//				isOk =false;
//			}
//			if(reMatKhau== null || reMatKhau.equals("")) {
//				erorr.put("NoRePass", "Trường này không được bỏ trống");
//				isOk =false;
//			}
//			//check có trùng tài khoản không
//
//			// check mật khẩu
//			if(!matKhau.equals(reMatKhau)) {
//				erorr.put("erorrRepass", "Mật khẩu không trùng khớp");
//				isOk =false;
//			}
//			if(isOk) {
//				try {
//					String ten = request.getParameter("name");
//					String email = request.getParameter("email");
//					String sdt = request.getParameter("telephone");
//					String diaChi = request.getParameter("address");
//					int quyen = Integer.parseInt(request.getParameter("rights"));
//					User user = new User(tenTaiKhoan, matKhau, ten, sdt, email, diaChi, quyen);
//					new AccountDAO().add(user);
//					request.setAttribute("tkAdmin",  new AccountDAO().mapAccount);
////					Log log = new Log(Log.ALERT,tkLogin.getNameAcc(),src,"Add: " + user.toString(),1);
////					new LogDAO().add(log,request);
//					getServletContext().getRequestDispatcher("/admin/manage?loai=user").forward(request, response);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.out.println(e.getMessage());
//				}
//			}else {
////				Log log = new Log(Log.WARNING,tkLogin.getNameAcc(),src,"Add false: " + erorr.toString(),1);
////				new LogDAO().add(log,request);
//				request.setAttribute("erorr", erorr);
//				getServletContext().getRequestDispatcher("/admin/addUser.jsp").forward(request, response);
//			}
//
//
//		}
//		String taikhoan = request.getParameter("userName");
//		if(chucNang.equals("Sua")) {
//			ServletContext contextID = getServletContext();
//			String id = (String) contextID.getAttribute("id");
//			String tenTaiKhoan = request.getParameter("userName");
//			String matKhau = request.getParameter("passWord");
//			String reMatKhau = request.getParameter("rePassWord");
//			boolean isOk = true;
//			try {
//				String query = "select * from USERS";
//				Connection connect = new Connect().getconnecttion();
//				Statement stmt =  connect.createStatement();
//				ResultSet rs=	stmt.executeQuery(query);
//				while (rs.next()) {
//					if(rs.getString(1).equals(tenTaiKhoan) && taikhoan!= tenTaiKhoan) {
//						erorr.put("duplicateUserName", "Tài khoản đã tồn tại");
//						isOk =false;
//					}
//
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			if(isOk) {
//				String ten = request.getParameter("name");
//				String email = request.getParameter("email");
//				String sdt = request.getParameter("telephone");
//				String diaChi = request.getParameter("address");
//				int quyen = Integer.parseInt(request.getParameter("rights"));
////				matKhau = EncryptionPass.toSHA1(matKhau);
////				Log log = new Log(Log.ALERT,tkLogin.getNameAcc(),src,"Edit" + tk.mapAccount.get(id).toString(),1);
////				new LogDAO().add(log,request);
//				User user = new User(id, matKhau, ten, sdt, email, diaChi, quyen);
//				new AccountDAO().editUser(id, user);
//				request.setAttribute("tkAdmin", tk.mapAccount);
//				getServletContext().getRequestDispatcher("/admin/manage?loai=user").forward(request, response);
//			}else {
////				Log log = new Log(Log.WARNING,tkLogin.getNameAcc(),src,"Edit False" + tk.mapAccount.get(id).toString(),1);
////				new LogDAO().add(log,request);
//				request.setAttribute("erorr", erorr);
//				getServletContext().getRequestDispatcher("/admin/addUser.jsp").forward(request, response);
//			}
//
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		doGet(request, response);
//	}
//
//}
