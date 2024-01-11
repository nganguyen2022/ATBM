package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.AccountDAO;
import models.Email;
import models.Keys;
import models.RSAKey;
import models.User;

@WebServlet("/Key")
public class Key extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Key() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User tk = (User) session.getAttribute("user");
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            AccountDAO acc = new AccountDAO();
            String time = String.valueOf(LocalDateTime.now());

            // Kiểm tra xem tk có null hay không
            if (tk != null) {
                try{
                    RSAKey rsaKey = new RSAKey();
                    rsaKey.genKey();

                    // Lấy khóa public và private dưới dạng chuỗi Base64
                    String publicKey = rsaKey.getPublicKeyBase64();
                    String privateKey = rsaKey.getPrivateKeyBase64();

                    String privateFile = "private.txt";
                    String publicFile = "public.txt";

                    try (FileOutputStream fos = new FileOutputStream(privateFile)) {
                        fos.write(privateKey.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try (FileOutputStream fos = new FileOutputStream(publicFile)) {
                        fos.write(publicKey.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Email email = new Email();
                    email.setFrom("20130077@st.hcmuaf.edu.vn");
                    email.setTo(tk.getEmail());
                    email.setFromPass("cyoquivbqrbfuqti");
                    email.setSubject("DHStore - Private");

                    StringBuilder sb = new StringBuilder();
                    sb.append("<div style=\"font-size:16px;color:black;\">");
                    sb.append("<p style=\"font-size:24px;\">Tải private key</p>");
                    sb.append("<span>Xin chào </span>" + tk.getFullName()).append("<br><br>");
                    sb.append("<span>Đây là private key của bạn: </span>").append("<br>");

                    // Đính kèm private key vào email
                    MimeBodyPart attachmentPart = new MimeBodyPart();
                    attachmentPart.setDataHandler(new DataHandler(new FileDataSource(privateFile)));
                    attachmentPart.setFileName(privateFile);

                    // Tạo đối tượng MimeMultipart để kết hợp văn bản và file đính kèm
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(attachmentPart);

                    // Thêm nội dung văn bản vào email
                    MimeBodyPart textPart = new MimeBodyPart();
                    textPart.setText(sb.toString(), "UTF-8", "html");

                    multipart.addBodyPart(textPart);

                    email.setContent(multipart);

                    SendEmail.sendEmail(email);

                    Keys key = new Keys(tk.getUname(), publicKey, time, 1);
                    if (acc.checkKey(tk.getUname())) {
                        acc.updateStatusKey(tk.getUname());
                        acc.addKeyNew(key, tk.getUname());
                    } else {
                        acc.addKeyNew(key, tk.getUname());
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/DetailUser").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
