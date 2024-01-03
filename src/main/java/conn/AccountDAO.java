package conn;

import java.sql.*;
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
//
public static Keys getKeyByUser(String username){
    try{
        String query = "select * from userkeys where userID = ?";
        Connection connect = new Connect().getconnecttion();
        PreparedStatement stmt = connect.prepareStatement(query);
        stmt.setString(1, username);
        System.out.println(stmt.toString());
        ResultSet rs= stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String user = rs.getString(2);
            String pk = rs.getString(3);
            String date = rs.getString(4);
            int status = rs.getInt(5);
            Keys key = new Keys(id,user,pk,date, status);
            return key;
        }
        return null;
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }

}

    public static Keys getKeyByUser(String username){
        try{
            String query = "select * from userkeys where userID = ?";
            Connection connect = new Connect().getconnecttion();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, username);
            System.out.println(stmt.toString());
            ResultSet rs= stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String pk = rs.getString(3);
                String date = rs.getString(4);
                int status = rs.getInt(5);
                Keys key = new Keys(id,user,pk,date, status);
                return key;
            }
            return null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    private static Map<String, User> loadData() {
        Map<String, User> mapTemp = new HashMap<String, User>();
        try {
            String query = "select * from USERS";
            Connection connect = new Connect().getconnecttion();
            Statement stmt =  connect.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while (rs.next()) {
                String fullName = rs.getString(2);
                String userName = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String pass = rs.getString(7);
                int isUser = rs.getInt(8);

                User user = new User(fullName, userName, email, phone, address, pass, isUser);
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
public boolean add(Object obj, Object obj1) {
    User tk = (User) obj;
    Keys key = (Keys) obj1;

    String sqlInsertUser = "INSERT INTO USERS (fullname, userName, email, phone, address, upassword, isUser) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String sqlInsertUserKey = "INSERT INTO USERKEYS (userID, publicKey, date_time, key_status) VALUES (?, ?, ?, ?)";

    try {
        Connection connect = new Connect().getconnecttion();
        connect.setAutoCommit(false); // Disable auto-commit

        // Insert into USERS table
        try (PreparedStatement ppstmUser = connect.prepareStatement(sqlInsertUser)) {
            ppstmUser.setString(1, tk.getFullName());
            ppstmUser.setString(2, tk.getUname());
            ppstmUser.setString(3, tk.getEmail());
            ppstmUser.setString(4, tk.getPhone());
            ppstmUser.setString(5, tk.getAddress());
            ppstmUser.setString(6, tk.getPass());
            ppstmUser.setInt(7, tk.getIsUser());
            ppstmUser.executeUpdate();
        }

        // Insert into USERKEYS table
        try (PreparedStatement ppstmUserKey = connect.prepareStatement(sqlInsertUserKey)) {
            ppstmUserKey.setString(1, tk.getUname()); // Assuming username is used as userID
            ppstmUserKey.setString(2, key.getPublicKey());
            ppstmUserKey.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ppstmUserKey.setInt(4, 1); // Assuming 1 represents an active key
            ppstmUserKey.executeUpdate();
        }

        connect.commit(); // Commit the transaction
        connect.setAutoCommit(true); // Enable auto-commit again

        return true;
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
    return false;
}


    public boolean update(Object obj, Object obj1) {
        User tk = (User) obj;
        Keys key = (Keys) obj1;

        String sqlUpdateUser = "UPDATE USERS SET fullname=?, email=?, phone=?, address=?, upassword=?, isUser=? WHERE userName=?";
        String sqlUpdateUserKey = "UPDATE USERKEYS SET publicKey=?, date_time=?, key_status=? WHERE userID=?";

        try {
            Connection connect = new Connect().getconnecttion();
            connect.setAutoCommit(false); // Disable auto-commit

            // Update USERKEYS table
            try (PreparedStatement ppstmUserKey = connect.prepareStatement(sqlUpdateUserKey)) {
                ppstmUserKey.setString(1, key.getPublicKey());
                ppstmUserKey.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                ppstmUserKey.setInt(3, 1); // Assuming 1 represents an active key
                ppstmUserKey.setString(4, tk.getUname()); // Assuming username is used as userID
                ppstmUserKey.executeUpdate();
            }

            // Update USERS table
            try (PreparedStatement ppstmUser = connect.prepareStatement(sqlUpdateUser)) {
                ppstmUser.setString(1, tk.getFullName());
                ppstmUser.setString(2, tk.getEmail());
                ppstmUser.setString(3, tk.getPhone());
                ppstmUser.setString(4, tk.getAddress());
                ppstmUser.setString(5, tk.getPass());
                ppstmUser.setInt(6, tk.getIsUser());
                ppstmUser.setString(7, tk.getUname());
                ppstmUser.executeUpdate();
            }

            connect.commit(); // Commit the transaction
            connect.setAutoCommit(true); // Enable auto-commit again

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
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
                return new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(String userName) {
        String sqlDeleteUser = "DELETE FROM USERS WHERE userName=?";
        String sqlDeleteUserKey = "DELETE FROM USERKEYS WHERE userID=?";

        try {
            Connection connect = new Connect().getconnecttion();
            connect.setAutoCommit(false); // Disable auto-commit

            // Delete from USERKEYS table
            try (PreparedStatement ppstmUserKey = connect.prepareStatement(sqlDeleteUserKey)) {
                ppstmUserKey.setString(1, userName); // Assuming username is used as userID
                ppstmUserKey.executeUpdate();
            }

            // Delete from USERS table
            try (PreparedStatement ppstmUser = connect.prepareStatement(sqlDeleteUser)) {
                ppstmUser.setString(1, userName);
                ppstmUser.executeUpdate();
            }

            connect.commit(); // Commit the transaction
            connect.setAutoCommit(true); // Enable auto-commit again

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        System.out.println(a.getAllUsers());
    }
}
