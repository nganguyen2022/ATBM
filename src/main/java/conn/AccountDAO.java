package conn;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.*;

public class AccountDAO implements ObjectDAO{
    public static Map<String, User> mapAccount = loadData();


    public AccountDAO() {
        // TODO Auto-generated constructor stub
    }
    //
    public static Keys getKeyByUser(String username){
        try{
            String query = "select * from userkeys where userID = ? AND key_status = 1";
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

    public static List<Keys> getKey0ByUser(String username){
        List<Keys> keys = new ArrayList<>();
        try{
            String query = "select * from userkeys where userID = ? AND key_status = 0";
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
                keys.add(key);
            }
            return keys;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public int countStatus0(String userName){
        int count = 0;
        try {
            String query = "SELECT COUNT(publicKey) AS row_count FROM USERKEYS WHERE userID = ? AND key_status = 0";
            Connection conn = new Connect().getconnecttion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("row_count");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public String getTimePublicKey(String userName){
        String date_time = null;
        try{
            String query = "SELECT date_time FROM USERKEYS WHERE userID = ? AND key_status = 1 ORDER BY date_time DESC LIMIT 1";
            Connection conn = new Connect().getconnecttion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                date_time = rs.getString("date_time");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return date_time;
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

    public void updateStatusKey(String userName){
        String query = "UPDATE USERKEYS SET key_status = 0 WHERE userID = ? AND key_status = 1";
        try{
            Connection con = new Connect().getconnecttion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName); // Assuming username is used as userID
            ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addKeyNew(Object obj, String userName){
        Keys key = (Keys) obj;
        String query1 = "INSERT INTO USERKEYS (userID, publicKey, date_time, key_status) VALUES (?, ?, ?, 1)";
        try{
            Connection con = new Connect().getconnecttion();
            PreparedStatement pre = con.prepareStatement(query1);

            pre.setString(1, userName);
            pre.setString(2, key.getPublicKey());
            pre.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pre.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean checkKey(String userName){
        String sql = "SELECT Count(publicKey) FROM USERKEYS WHERE userID = ? AND key_status = 1";
        try{
            Connection con = new Connect().getconnecttion();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, userName);
            try (ResultSet resultSet = pre.executeQuery()){
                if (resultSet.next()){
                    int count = resultSet.getInt(1);
                    return count > 0; // If count > 0, the key already exists
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        System.out.println(a.getAllUsers());
    }
}