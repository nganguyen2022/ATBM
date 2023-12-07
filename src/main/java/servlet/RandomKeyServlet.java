package servlet;

import models.RSAKey;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RandomKeyServlet")
public class RandomKeyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            RSAKey rsaKey = new RSAKey();
            rsaKey.genKey();

            // Lấy khóa public và private dưới dạng chuỗi Base64
            String publicKey = rsaKey.getPublicKeyBase64();
            String privateKey = rsaKey.getPrivateKeyBase64();

            // Tạo đối tượng JSON để trả về
            String jsonResponse = String.format("{\"publicKey\":\"%s\", \"privateKey\":\"%s\"}", publicKey, privateKey);

            // Thiết lập các thuộc tính của phản hồi
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Gửi chuỗi JSON làm phản hồi
            response.getWriter().write(jsonResponse);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
