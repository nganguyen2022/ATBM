package conn;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.DetailOrder;
import models.User;
import models.Category;
import models.Product;
import java.util.Date;
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
				e.printStackTrace();
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
		String query = "SELECT * FROM USERS WHERE userName = ? and upassword = ?";
		try {
			conn = new Connect().getconnecttion();
			ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(
						rs.getString("fullname"),
						rs.getString("userName"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("upassword"),
						rs.getInt("isUser")
				);
			}
		} catch (Exception e) {

		}
		return null;

	}
		
	// kt xem user co ton tai chua
	public User checkUser(String uname) {
		String query = "SELECT * FROM USERS WHERE userName = ?";
		try {
			conn =new Connect().getconnecttion();
			ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {

		}
		return null;
	}

	public static void register(String fullName, String userName, String email, String phone, String address,
								String password, String publicKey, String privateKey) {
		try (Connection conn = new Connect().getconnecttion()) {
			registerUser(conn, fullName, userName, email, phone, address, password);
			registerUserKey(conn, userName, publicKey);

			// Save private key to file
			savePrivateKeyToFile(userName, privateKey);

			System.out.println("User registered successfully!");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}


	private static void registerUser(Connection conn, String fullName, String userName, String email, String phone,
									 String address, String password) throws SQLException {
		String insertUserQuery = "INSERT INTO USERS (fullname, userName, email, phone, address, upassword, isUser) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement userStatement = conn.prepareStatement(insertUserQuery)) {
			userStatement.setString(1, fullName);
			userStatement.setString(2, userName);
			userStatement.setString(3, email);
			userStatement.setString(4, phone);
			userStatement.setString(5, address);
			userStatement.setString(6, password);
			userStatement.setInt(7, 1); // Assuming 1 represents a regular user

			userStatement.executeUpdate();
		}
	}

	private static void registerUserKey(Connection conn, String userName, String publicKey) throws SQLException {
		String insertUserKeyQuery = "INSERT INTO USERKEYS (userID, publicKey, date_time, key_status) VALUES (?, ?, ?, ?)";
		try (PreparedStatement userKeyStatement = conn.prepareStatement(insertUserKeyQuery)) {
			userKeyStatement.setString(1, userName);
			userKeyStatement.setString(2, publicKey);
			userKeyStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			userKeyStatement.setInt(4, 1); // Assuming 1 represents an active key

			userKeyStatement.executeUpdate();
		}
	}
	private static void savePrivateKeyToFile(String username, String privateKey) throws IOException {
		// Tạo đường dẫn mới cho mỗi người dùng
		String baseDirectory = "D:\\KEYS\\";
		String userDirectory = baseDirectory + username + "\\";

		// Tạo thư mục mới nếu nó không tồn tại
		File directory = new File(userDirectory);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		// Tạo đường dẫn cho file private key
		String filePath = userDirectory + "private_key.txt";

		try (PrintWriter writer = new PrintWriter(filePath)) {
			writer.write(privateKey);
		}
	}
	public boolean isPublicKeyExists(String publicKey) {

		// Prepare the SQL statement
		String query = "SELECT COUNT(*) FROM USERKEYS WHERE publicKey = ?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, publicKey);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count > 0; // If count > 0, the key already exists
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return false;
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
