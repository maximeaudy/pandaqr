package pandaqr.mail;
import java.util.Properties;
import java.util.Calendar;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {
   public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "leahelary03@gmail.com";//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "pandaqr1@gmail.com";//change accordingly
      final String username = "pandaqr1@gmail.com";//change accordingly
      final String password = "Azerty11+";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.ssl.trust","*");
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Invitation à la réunion");
         Calendar cal = Calendar.getInstance();
         cal.set(2019, 11, 10);
         // Now set the actual message
         message.setText("Vous avez été invité à la réunion de $michel pour le 11/12/2019 à 15h15. "+ cal.toString() );

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}