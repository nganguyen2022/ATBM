package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.*;
import conn.*;

public class AccountDAO implements ObjectDAO{
    public static Map<String, User> mapAccount = loadData();


    public AccountDAO() {
        // TODO Auto-generated constructor stub
    }

    private static Map<String, User> loadData() {
        Map<String, User> mapTemp = new HashMap<String, User>();
        try {
            String query = "select * from USERS";
            Connection connect = new Connect().getconnecttion();
            Statement stmt =  connect.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while (rs.next()) {
                String fullName = rs.getString(1);
                String userName = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String address = rs.getString(5);
                String pass = rs.getString(6);
                String publicKey = rs.getString(7);
                String privateKey = rs.getString(8);
                int isUser = rs.getInt(9);

                User user = new User(fullName, userName, email, phone, address, pass, publicKey, privateKey, isUser);
                mapTemp.put(user.getUname(), user);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mapTemp;

    }

//    public boolean changePass(String userName, String newPass) {
//        Account user = mapAccount.get(userName);
//        if (user != null) {
//            user.setPassword(newPass);
//            mapAccount.replace(user.getNameAcc(), user);
//            edit(user.getNameAcc(), user);
//            return true;
//        } else {
//            return false;
//        }
//    }

//	public static boolean sendMail(String to, String subject, String text) {
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("ntkien123@gmail.com", "");
//			}
//		});
//		try {
//			Message message = new MimeMessage(session);
//			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
//			message.setFrom(new InternetAddress("shopphoneltw@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			message.setSubject(subject);
//			message.setText(text);
//			Transport.send(message);
//		} catch (MessagingException e) {
//			e.getMessage();
//			return false;
//		}
//
//		return true;
//	}

//	public boolean passRecorvery(String userName, String email) {
//
//		Account tk = mapAccount.get(userName);
//		if (tk != null) {
//			sendMail(email, "Cập nhật lại mật khẩu", tk.getPassword());
//			return true;
//		} else {
//			return false;
//		}
//
//	}
    public boolean add(Object obj) {
        User tk = (User) obj;
        mapAccount.put(tk.getUname(), tk);
        String sql = "insert into USERS values(?,?,?,?,?,?,?,?,?)";

        try {
            Connection connect = new Connect().getconnecttion();
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, tk.getFullName());
            ppstm.setString(2, tk.getUname());
            ppstm.setString(3, tk.getEmail());
            ppstm.setString(4, tk.getPhone());
            ppstm.setString(5, tk.getAddress());
            ppstm.setString(6, tk.getPass());
            ppstm.setString(7, tk.getPublicKey());
            ppstm.setString(8, tk.getPrivateKey());
            ppstm.setInt(9, tk.getIsUser());
            ppstm.executeUpdate();
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void editUser(String userName, String upassword, String fullName, String phone, String email, String address, int isUser) {
        String query = "UPDATE USERS SET upassword=?, fullName=?, phone=?, email=?, address=?, isUser=? WHERE userName=?;";
        try {
            Connection conn =new Connect().getconnecttion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, upassword);
            ps.setString(2, fullName);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setInt(6, isUser);
            ps.setString(7, userName);
            ps.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static List<User> getAllUsers() {
        Map<String, User> userMap = loadData();
        return new ArrayList<>(userMap.values());
    }

    public User getUserByName(String userName){
        String query = "SELECT * FROM USERS WHERE userName = ?";
        try {
            Connection conn = new Connect().getconnecttion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),rs.getString(7),
                        rs.getString(8), rs.getInt(9));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(String nameAcc) {
        mapAccount.remove(nameAcc);
        try {
            String sql = "delete from USERS where userName='" + nameAcc + "'";
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

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        System.out.println(a.getAllUsers());
    }
}
