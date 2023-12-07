package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public Connection getconnecttion ()throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/WEBCLOTHES";
			String user = "root";
			String pass = "24082002";
			return DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException {
//		// TODO Auto-generated method stub
//			try {
//				new Connect();
//				System.out.println(Connect.getconnecttion());
//			}catch (SQLException e) {
//			e.getStackTrace() ;
//			}

	}

}
