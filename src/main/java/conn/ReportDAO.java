package conn;

import models.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public void add(Report r, String userName){
        String query = "INSERT INTO Report (timeR, userName, fullName, email, phone, descriptionR, status) VALUES (?,?,?,?,?,?,1)";
        try{
            Connection conn = new Connect().getconnecttion();
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pre.setString(2, userName);
            pre.setString(3, r.getFullName());
            pre.setString(4, r.getEmail());
            pre.setString(5, r.getPhone());
            pre.setString(6, r.getDescription());
            pre.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Report> getReportByUserName(String userName){
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM Report WHERE userName = ?";
        try{
            Connection conn = new Connect().getconnecttion();
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, userName);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Timestamp time = rs.getTimestamp("timeR");
                String dateReport = null;
                if (time != null) {
                    dateReport = String.valueOf(time.toLocalDateTime());
                }
                if (dateReport != null) {
                    Report report = new Report();
                    report.setTime(dateReport);
                    report.setFullName(rs.getString("fullName"));
                    report.setEmail(rs.getString("email"));
                    report.setPhone(rs.getString("phone"));
                    report.setDescription(rs.getString("descriptionR"));
                    report.setStatus(rs.getInt("status"));
                    reports.add(report);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return reports;
    }
}
