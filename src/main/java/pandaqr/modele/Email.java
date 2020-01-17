package pandaqr.modele;

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
}
/*	public static void main(String[] args) {
		try {
			Email email = new Email();
			email.send("maximed.ipod@gmail.com", "nouvelle sieste", "je sens que cette sieste va être une pure soirée",
					"20191213T163000Z", "20191213T170000Zo", "maximedelx@gmail.com", "105");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}*/
	