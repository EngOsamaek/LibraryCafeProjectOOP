package Email;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class EmailUtil {

    String toEmail;
    public void sendEmail(String toEmail,String message){
        try {

            final String fromEmail = "lcpaydin@gmail.com"; //requires valid gmail id
            final String password = "Osama_2001$"; // correct password for gmail id
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(fromEmail, "IAU Library"));

            msg.setReplyTo(InternetAddress.parse("lcpaydin@gmail.com", false));

            msg.setSubject("Book Loan", "UTF-8");

            msg.setText(message, "UTF-8");


            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
