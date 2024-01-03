package models;

public class Report {

    private String time;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private String description;
    private int status;

    public Report(String time, String userName, String fullName, String email, String phone, String description, int status) {
        this.time = time;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.status = status;
    }

    public Report(String time, String fullName, String email, String phone, String description, int status) {
        this.time = time;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.status = status;
    }

    public Report() {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Report{" +
                "time=" + time +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
