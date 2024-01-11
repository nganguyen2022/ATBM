package conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.*;


import com.google.gson.Gson;
import models.OrderProduct;

public class OrderDAO implements ObjectDAO {
	public static Map<String, OrderProduct> mapDonHang = loadData();

	public OrderDAO() {
		// TODO Auto-generated constructor stub
	}
	public static Map<String, OrderProduct> loadData(){
		Map<String, OrderProduct> mapTemp = new HashMap<String, OrderProduct>();
		try {
			String query = "select * from OrderProduct";
			Connection connect = new Connect().getconnecttion();
			Statement stmt =  connect.createStatement();
			ResultSet rs=	stmt.executeQuery(query);

			while (rs.next()) {
				String idOrder = rs.getString(1);
				String nameAcc  = rs.getString(2);
				String dateOrder  = rs.getString(3);
				String dateDelivery  = rs.getString(4);
				String totalMoney  = rs.getString(5);
				String phone  = rs.getString(6);
				String nameRecipient  = rs.getString(7);
				String address  = rs.getString(8);
				String note  = rs.getString(9);
				String checkout = rs.getString(10);
				String status  = rs.getString(11);
				String signature  = rs.getString(12);
				OrderProduct donHang = new OrderProduct(idOrder, nameAcc, dateOrder,dateDelivery, totalMoney, phone, nameRecipient, address, note, checkout, status, signature);
				mapTemp.put(donHang.getIdOrder(), donHang);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;

	}
	@Override
	public boolean add(Object obj) {
		OrderProduct sp = (OrderProduct) obj;
		mapDonHang.put(sp.getIdOrder(), sp);
		String sql = "insert into OrderProduct values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection connect = new Connect().getconnecttion();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,sp.getIdOrder());
			ppstm.setString(2,sp.getNameAcc());
			ppstm.setString(3, sp.getDateOrder());
			ppstm.setString(4,sp.getDateDelivery());
			ppstm.setString(5,sp.getTotalMoney());
			ppstm.setString(6,sp.getPhone());
			ppstm.setString(7,sp.getNameRecipient());
			ppstm.setString(8,sp.getAddress());
			ppstm.setString(9,sp.getNote());
			ppstm.setString(10,sp.getCheckout());
			ppstm.setString(11, sp.getStatus());
			ppstm.setString(12, sp.getSignature());
			ppstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	//HỦY
	public boolean cancel(String id ){
		OrderProduct on = mapDonHang.get(id);
		System.out.println("Order -----status before update: " + on.getStatus());
		if ("1".equals(on.getCheckout())) {
			on.setStatus("3");
		} else {
			on.setStatus("2");
		}

		mapDonHang.replace(id, on);

		try (Connection connect = new Connect().getconnecttion();
			 PreparedStatement ppstm = connect.prepareStatement("update OrderProduct set status=? where idOrder=?")) {

			ppstm.setInt(1, Integer.parseInt(on.getStatus()));
			ppstm.setString(2, id);

			System.out.println("--thihau----"+ppstm.toString() + "--thihau----");


			ppstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// Xử lý ngoại lệ liên quan đến cơ sở dữ liệu
			System.out.println("LỖI CSDL " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// Xử lý ngoại lệ chung
			e.printStackTrace();
		}

		return false;

	}


	@Override
	public boolean edit(String id, Object obj) {
		OrderProduct donHang = (OrderProduct) obj;
		mapDonHang.replace(id, donHang);
		try {
			String sql = "update OrderProduct set nameAcc=?,dateOrder=?,dateDelivery=?,totalMoney=?,phone=?," +
					"nameRecipient=?,address=?,note=?, checkout=?,status=?, signature=? where idOrder=?";
			Connection connect = new Connect().getconnecttion();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1,donHang.getNameAcc());
			ppstm.setString(2, donHang.getDateOrder());
			ppstm.setString(3,donHang.getDateDelivery());
			ppstm.setString(4,donHang.getTotalMoney());
			ppstm.setString(5,donHang.getPhone());
			ppstm.setString(6,donHang.getNameRecipient());
			ppstm.setString(7,donHang.getAddress());
			ppstm.setString(8,donHang.getNote());
			ppstm.setString(9, donHang.getCheckout());
			ppstm.setString(10,donHang.getStatus());
			ppstm.setString(11,donHang.getSignature());
			ppstm.setString(12,donHang.getIdOrder());

			System.out.println(ppstm.toString() + "------");

			ppstm.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}
	@Override
	public boolean delete(String id) {
		mapDonHang.remove(id);
		try {

			String sql = "delete from OrderProduct where idOrder='"+id+"'";
			Connection connect = new Connect().getconnecttion();
			Statement stmt =  connect.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public List<OrderProduct> top5DonHang(String userName){
		try {
			String query = "with x as (select *, ROW_NUMBER() over (order by dateOrder DESC) as r from OrderProduct  where nameAcc = ? )\r\n"
					+ "	select * from x where r between 1 and 5";
			Connection connect = new Connect().getconnecttion();
			PreparedStatement ppstm = connect.prepareStatement(query);
			ppstm.setString(1, userName);
			ResultSet rs = null;
			rs =ppstm.executeQuery();
			List<OrderProduct> list = new ArrayList<OrderProduct>();
			while(rs.next()) {
				OrderProduct sp = new OrderProduct(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12)
				);
				list.add(sp);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public int  getOrderNotProcessed(){
		int numOrderNoProcessed = 0;
		for(OrderProduct o : mapDonHang.values()){
			if(o.getStatus().equals("0")){
				numOrderNoProcessed++;
			}
		}
		System.out.println(numOrderNoProcessed);
		return numOrderNoProcessed;
	}
	public int getTotloPriceYear(){
		int rs = 0;
		for(OrderProduct o : mapDonHang.values()){
			if(o.getStatus().equals("1")){
				rs+= Double.parseDouble(o.getTotalMoney());
			}
		}
		System.out.println(rs);

		return rs;
	}
	public int getTotalMonthNow(){
		// Lấy thời gian hiện tại
		Calendar calendar = Calendar.getInstance();
		// Lấy ngày, tháng và năm từ thời gian hiện tại
		int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, nên cần cộng 1
		int year = calendar.get(Calendar.YEAR);
		String sql = "select sum(totalMoney) from OrderProduct where " + month+" = month(now()) and "+ year +" = year(now()) and status =1";

		try {
			Connection connect = new Connect().getconnecttion();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ResultSet rss = null;
			rss =ppstm.executeQuery();

			while(rss.next()) {
				int	total = rss.getInt(1);
				return total;

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		OrderDAO dh = new OrderDAO();

//		System.out.println(dh.top5DonHang("anphan219"));
//		System.out.println(dh.maxMaDH());
//		System.out.println(dh.searchByAttribute(1, 1, null));
		System.out.println(dh.getTotalMonthNow());
	}


}
