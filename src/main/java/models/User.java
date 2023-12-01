package models;

public class User {
	private String uname;
	private String pass;
	private String email;
	private int isUser;
	public User(String uname, String pass, String email, int isUser) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.email = email;
		this.isUser = isUser;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsUser() {
		return isUser;
	}
	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", pass=" + pass + ", email=" + email + ", isUser=" + isUser + "]";
	}
	

}
