package servlet;

import models.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void sendEmail(Email email) {
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            // Kết nối với smtp
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email.getFrom(), email.getFromPass());
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email.getFrom()));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
                message.setSubject(email.getSubject());
                message.setContent(email.getContent());
                Transport.send(message);
            } catch (Exception e) {
                e.getStackTrace();
        }
    }
}
