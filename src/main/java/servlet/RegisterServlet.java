package servlet;

import conn.Load;
import models.EncryptPass;
import models.User;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String full_name = request.getParameter("full_name");
		String uname = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String publicKey = request.getParameter("publicKey");
		String privateKey = request.getParameter("privateKey");

		if (!isValidUsername(uname)) {
			request.setAttribute("messuname", "Tên người dùng không hợp lệ! Chỉ chấp nhận chữ cái thường và chữ số.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!isValidEmail(email)) {
			request.setAttribute("messmail", "Định dạng email không hợp lệ!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!isValidRSAKey(publicKey,privateKey)) {
			request.setAttribute("messkeys", "Định dạng của khóa không hợp lệ!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		if (!isValidRSAKeyPair(publicKey, privateKey)) {
			request.setAttribute("messkeyss", "Khóa công khai và khóa riêng tư không hợp lệ!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		if (!isValidPassword(pass)) {
			request.setAttribute("messpass", "Mật khẩu phải có ít nhất 6 ký tự và 1 ký tự đặc biệt!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (!pass.equals(repass)) {
			request.setAttribute("mess", "Mật khẩu bạn nhập không khớp!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			Load load = new Load();
			User u = load.checkUser(uname);
			if (u == null) {
				try {
					pass = EncryptPass.toSHA1(pass);

					// Check if user selected "Already have key" and provided a public key
					if (request.getParameter("alreadyHaveAccount") != null && publicKey != null && !publicKey.isEmpty()) {
						// Check if the provided public key already exists in the database
						if (load.isPublicKeyExists(publicKey)) {
							// Public key already exists, show error message
							request.setAttribute("messkeys", "Khóa đã tồn tại trong hệ thống!");
							request.getRequestDispatcher("register.jsp").forward(request, response);
							return;
						}
					}

					load.register(full_name, uname, email, phone, address, pass, publicKey, privateKey);
					response.sendRedirect("login.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("mess", "An error occurred during registration.");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("userexit", "Tài khoản đã tồn tại!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
	private boolean isValidUsername(String username) {
		// Tên người dùng chỉ chấp nhận chữ cái thường và chữ số, không chứa ký tự đặc biệt và dấu cách
		String usernameRegex = "^[a-z0-9]+$";
		Pattern pattern = Pattern.compile(usernameRegex);
		return pattern.matcher(username).matches();
	}
	private boolean isValidPassword(String password) {
		// Mật khẩu bao gồm 6 ký tự và chứa 1 ký tư đặc biệt
		String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{6,}$";

		//Biên dịch mẫu
		Pattern pattern = Pattern.compile(passwordRegex);

		// Xác thực mật khẩu theo mẫu đã định dạng
		return pattern.matcher(password).matches();
	}
	private boolean isValidEmail(String email) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pattern = Pattern.compile(emailRegex);

		return pattern.matcher(email).matches();
	}
	public static boolean isValidRSAKey(String publicKey, String privateKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			// Kiểm tra định dạng của khóa công khai
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
			keyFactory.generatePublic(publicKeySpec);

			// Kiểm tra định dạng của khóa riêng tư
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			keyFactory.generatePrivate(privateKeySpec);

			return true;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			return false;
		}
	}

	public static boolean isValidRSAKeyPair(String publicKey, String privateKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			// Check the format of the public key
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
			keyFactory.generatePublic(publicKeySpec);

			// Check the format of the private key
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			keyFactory.generatePrivate(privateKeySpec);

			// Check if the public and private keys form a valid key pair
			return isKeyPairMatch(publicKey, privateKey);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			return false;
		}
	}

	private static boolean isKeyPairMatch(String publicKey, String privateKey) {
		// Compare the modulus of the public and private keys
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
			RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);

			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);

			// Check if the modulus of the public key matches the modulus of the private key
			return pubKey.getModulus().equals(privKey.getModulus());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			return false;
		}
	}
}
