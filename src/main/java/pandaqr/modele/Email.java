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

