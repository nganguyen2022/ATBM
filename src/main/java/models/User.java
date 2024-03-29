package models;

public class User {
	private String uname;
	private String pass;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private int isUser;

	public User(String fullName, String uname, String email, String phone, String address,
				String pass, int isUser) {
		this.uname = uname;
		this.pass = pass;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.isUser = isUser;
	}

	public User() {
	}

	public User(String uname) {
		this.uname = uname;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsUser() {
		return isUser;
	}

	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}

	@Override
	public String toString() {
		return "User{" +
				"uname='" + uname + '\'' +
				", pass='" + pass + '\'' +
				", fullName='" + fullName + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", isUser=" + isUser +
				'}';
	}
}
