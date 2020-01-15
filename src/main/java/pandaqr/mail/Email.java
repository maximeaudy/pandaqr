package pandaqr.mail;

import java.util.Date;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

//import pandaqr.calendar.gmail;

public class Email {
	private Date dateDebut;
	private Date dateFin;
	private String mailOrganisateur;
	private int numSalle;
	private String description;
	private String titre;
	private String listParticipants;
	



/*    public static void main(String[] args) {
        try {
            Email email = new Email();
            email.send("maximed.ipod@gmail.com","nouvelle sieste", "je sens que cette sieste va être une pure soirée","20191213T163000Z","20191213T170000Zo","maximedelx@gmail.com",105);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void send(String listParticipants, String titre, String description, String dateDebut,String dateFin,String mailOrganisateur,int numSalle) throws Exception {

        try {
            String from = "pandaqr1@gmail.com";
            String to = "pandaqr1@gmail.com";
            String bcc = listParticipants;

            final String username = "pandaqr1@gmail.com";//change accordingly
            final String password = "Azerty11+";//change accordingly
            
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host","smtp.gmail.com");
            prop.put("mail.smtp.ssl.trust","*");
            prop.put("mail.smtp.port", "587");

            Session session = Session.getInstance(prop,
            	      new javax.mail.Authenticator() {
            	         protected PasswordAuthentication getPasswordAuthentication() {
            	            return new PasswordAuthentication(username, password);
            	         }
            	      });
            // Define message
            MimeMessage message = new MimeMessage(session);
            message.addHeaderLine("method=REQUEST");
            message.addHeaderLine("charset=UTF-8");
            message.addHeaderLine("component=VEVENT");

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            if (bcc.contains(";")) {
            	String[] dest ;
            	dest = bcc.split(";");
            	for(String destinataire : dest){
            		message.addRecipient(Message.RecipientType.BCC, new InternetAddress(destinataire));
            	}
            }else {
            	message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }
            
            message.setSubject("Invitation à la réunion du "+dateDebut);
            message.setText("Bonjour,\n"
            		+ "vous êtes invité à une nouvelle réunion."
            		+ "Celle ci commence le "+dateDebut+". "
                    + "Cordialement,"
                    + "PandaQR","utf-8","html");
            
            StringBuffer sb = new StringBuffer();

            StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
                    "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
                    "VERSION:2.0\n" +
                    "METHOD:REQUEST\n" +
                    "BEGIN:VEVENT\n" +
                    "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:"+listParticipants+"\n" +
                    "ORGANIZER:MAILTO:"+mailOrganisateur+"\n" +
                    "DTSTART:"+dateDebut+"\n" +
                    "DTEND:"+dateFin+"\n" +
                    "LOCATION:SALLE "+numSalle+"\n" +
                    "TRANSP:OPAQUE\n" +
                    "SEQUENCE:0\n" +
                    "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n" +
                    " 000004377FE5C37984842BF9440448399EB02\n" +
                    "DTSTAMP:20051206T120102Z\n" +
                    "CATEGORIES:Réunion\n" +
                    //description
                    "DESCRIPTION:"+description+"\n" +
                    // titre
                    "SUMMARY:"+titre+"\n" +
                    "PRIORITY:5\n" +
                    "CLASS:PUBLIC\n" +
                    "BEGIN:VALARM\n" +
                    "TRIGGER:PT1440M\n" +
                    "ACTION:DISPLAY\n" +
                    "END:VALARM\n" +
                    "END:VEVENT\n" +
                    "END:VCALENDAR");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
            messageBodyPart.setHeader("Content-ID", "calendar_message");
            messageBodyPart.setDataHandler(new DataHandler(
                    new ByteArrayDataSource(buffer.toString(), "text/calendar")));// very important


            BodyPart msgBodyPart = new MimeBodyPart();

            // Fill the message
            msgBodyPart.setText("Bonjour,"+ "vous êtes invité à une nouvelle réunion.\n"+ "Celle ci commence le "+dateDebut+". \n"+ "Cordialement,\n"+ "PandaQR");

            // Create a Multipart
            Multipart multipart = new MimeMultipart();
            
            // Add part one
            multipart.addBodyPart(msgBodyPart);

            // Add part one
            multipart.addBodyPart(messageBodyPart);

            // Put parts in message
            message.setContent(multipart);

            // send message
            Transport.send(message);
            System.out.println("email envoyé");
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}