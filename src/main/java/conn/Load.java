package conn;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.DetailOrder;
import models.User;
import models.Category;
import models.Product;

public class Load {
	Connection conn;
	PreparedStatement ps;// nem cau lenh query sang sql server
	ResultSet rs;// nhan kq tra ve

	public static Map<String,Product> mapProduct = loadData();
	public static Map<String, Product> loadData(){
		Map<String, Product> mapTemp = new HashMap<String, Product>();
		try{
			String query = "SELECT * FROM PRODUCT";
			Connection conn = new Connect().getconnecttion();// mo ket noi
			PreparedStatement ps = conn.prepareStatement(query);// nem lenh query
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String pId = rs.getString(1);
				String pName = rs.getString(2);
				Float price = rs.getFloat(3);
				String pDescription = rs.getString(4);
				String cateId = rs.getString(5);
				String img = rs.getString(6);
				Product product = new Product(pId, pName, price, pDescription, cateId, img);
				mapTemp.put(product.getpID(), product);
			}
		} catch(Exception e){

		}
		return mapTemp;
	}
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();// danh sach product
		String query = "SELECT * FROM PRODUCT";
		try {
			conn = new Connect().getconnecttion();// mo ket noi
			ps = conn.prepareStatement(query);// nem lenh query
			rs = ps.executeQuery();
			while (rs.next())
				list.add(new Product(rs.getString(1), 
						rs.getString(2), 
						rs.getFloat(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)));

		} catch (Exception e) {

		}

		return list;
	}
	
	// lấy all các danh mục
		public List<Category> getAllCategory() {
			List<Category> list = new ArrayList<>();
			String query = "SELECT * FROM CATEGORIES";
			try {
				conn =new Connect().getconnecttion();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next())
					list.add(new Category(rs.getString(1), rs.getString(2)));

			} catch (Exception e) {

			}

			return list;
		}
		
		// lấy sp theo Cate
		public List<Product> getProductByCateID(String cid) {
			List<Product> list = new ArrayList<>();// danh sach san pham
			String query = "SELECT * FROM PRODUCT WHERE cateId = ?";
			try {
				conn = new Connect().getconnecttion();// mo ket noi
				ps = conn.prepareStatement(query);// nem lenh query
				ps.setString(1, cid);
				rs = ps.executeQuery();
				while (rs.next())
					list.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),
							rs.getString(6)));

			} catch (Exception e) {

			}

			return list;
		}
		
		// lay sp theo product id
		public Product getProductById(String pid) {
			String query = "SELECT * FROM PRODUCT WHERE pId = ?";
			try {
				conn = new Connect().getconnecttion();
				ps = conn.prepareStatement(query);
				ps.setString(1, pid);
				rs = ps.executeQuery();
				while (rs.next())
					return new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),
							rs.getString(6));

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public List<Product> searchByName(String txtSearch) {
			List<Product> list = new ArrayList<>();// danh sach san pham
			String query = "SELECT * FROM PRODUCT WHERE pName like ?";
			try {
				conn = new Connect().getconnecttion();// mo ket noi
				ps = conn.prepareStatement(query);// nem lenh query
				ps.setString(1, "%" + txtSearch + "%");
				rs = ps.executeQuery();
				while (rs.next())
					list.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5),
							rs.getString(6)));

			} catch (Exception e) {

			}

			return list;
		}

	public User login(String uname, String pass) {
		String query = "SELECT * FROM USERS\n" + "WHERE userName = ? and upassword = ?";
		try {
			conn = new Connect().getconnecttion();
			ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (Exception e) {

		}
		return null;

	}
	// kt xem user co ton tai chua
	public User checkUser(String uname) {
		String query = "SELECT * FROM USERS\n" + "WHERE userName = ?";
		try {
			conn =new Connect().getconnecttion();
			ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (Exception e) {

		}
		return null;

	}
	public void register(String fullname, String username, String email, String phone, String address, String pass, String publicKey, String privateKey) {
		String query = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?, ?, ?, ?, 1)";
		try {
			conn =new Connect().getconnecttion();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, pass);
			ps.setString(7, publicKey);
			ps.setString(8, privateKey);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}
		// xóa sản phẩm
		public void deleteProduct(String pId) {
			String query = "DELETE FROM PRODUCT WHERE pId=?;";
			try {
				conn = new Connect().getconnecttion();
				ps = conn.prepareStatement(query);
				ps.setString(1, pId);
				ps.executeUpdate();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		// insert sản phẩm
		public void insertProduct(String id, String name, String price, String description, String cate, String img) {
			String query = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)";
			try {
				conn = new Connect().getconnecttion();
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, price);
				ps.setString(4, description);
				ps.setString(5, cate);
				ps.setString(6, img);
				ps.executeUpdate();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		// chỉnh sửa thông tin sản phẩm
		public void editProduct(String id, String name, String price, String description, String cate, String img) {
			String query = "UPDATE PRODUCT SET pName=?, price=?, pDescription=?, cateId=?, img=? WHERE pId=?;";
			try {
				conn =new Connect().getconnecttion();
				ps = conn.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, price);
				ps.setString(3, description);
				ps.setString(4, cate);
				ps.setString(5, img);
				ps.setString(6, id);
				ps.executeUpdate();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

	public List<Product> getSanPhamByDH(List<DetailOrder> list){
		List<Product> rs = new ArrayList<Product>();
		for (DetailOrder sanPham : list) {
			String IDsp = sanPham.getIdP();
			Product sp = getProductById(IDsp);
			rs.add(sp);
		}
		return rs;
	}
	public static void main(String[] args) {
		Load load = new Load();
		List<Product> list = load.getAllProduct();
		
		for (Product p : list) {
			System.out.println(p);
		}
		List<Category> listCat = load.getAllCategory();
		
		for (Category c : listCat) {
			System.out.println(c);
		}
	}

	
}
