package models;

public class User {
	private String uname;
	private String pass;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private String publicKey;
	private String privateKey;
	private int isUser;

	public User(String uname, String pass, String fullName, String phone, String email, String address, String publicKey, String privateKey, int isUser) {
		this.uname = uname;
		this.pass = pass;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
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

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
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
				", publicKey='" + publicKey + '\'' +
				", privateKey='" + privateKey + '\'' +
				", isUser=" + isUser +
				'}';
	}
}
