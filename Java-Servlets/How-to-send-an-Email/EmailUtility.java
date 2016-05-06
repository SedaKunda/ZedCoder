import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtility {
    public static void sendEmail(String host, String port, final String username, final String password, String address, 
            String subject, String message) throws AddressException, MessagingException {
    
        //sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        //creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        //creates a new e-mail message
        Message m = new MimeMessage(session);
 
        m.setFrom(new InternetAddress(username));
        InternetAddress[] addresses = { new InternetAddress(address) };
        m.setRecipients(Message.RecipientType.TO, addresses);
        m.setSubject(subject);
        m.setSentDate(new Date());
        m.setText(message);
 
        //sends e-mail
        Transport.send(m);
    }
}