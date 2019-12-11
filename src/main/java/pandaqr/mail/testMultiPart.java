package pandaqr.mail;


	public Email convertToMultipartMailObject(Email mail) {
		// Email text content. You might choose something more useful :)
		String messageBody = "This is the text content of the Email.";
		// Keep track if there were any errors within these method.
		boolean hasErrors = false;
		// Create the text part of the Email.
		MimeBodyPart messagePart = new MimeBodyPart();
		// Confluence Mails are Mime-Type text/html
		try {
			messagePart.setText(messageBody);
			messagePart.setHeader("Content-Type", "text/html");
		} catch (MessagingException e) {
			hasErrors = true;
			// I'm being lazy here, writing errors into the Email text string
			// you can do this more properly with logging and other mechanisms.
			messageBody = "ERROR: could not set body of multipart message!\n\n";
		}
		// This is going to be the text content of the Email .txt attachment.
		String attachment = "I'm gonna be the content of a .txt email attachment";
		// Create the Email attachment part.
		try {
			// "application/octet-stream" is the MIME-Type of choice for email attachments
			DataSource ds = new ByteArrayDataSource(attachment.getBytes("UTF-8"), "application/octet-stream");
			// Now we create the attachment part.
			MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.setDataHandler(new DataHandler(ds));
			// File name of the attachment.
			attachmentPart.setFileName("mycrazyattachment.txt");
			// We need a multipart object that indicates that this mail has
			// several different parts.
			Multipart multipart = new MimeMultipart();
			// We add the text part.
			multipart.addBodyPart(messagePart);
			// And the attachment part!
			multipart.addBodyPart(attachmentPart);
			// Finally, we add the multipart object.
			mail.setMultipart(multipart);
			// Of course you would do some better error handling than the following:
		} catch (MessagingException e) {
			hasErrors = true;
			messageBody = "ERROR: could not set attachment of multipart message!\n\n";
		} catch (UnsupportedEncodingException e) {
			hasErrors = true;
			messageBody = "ERROR: could not set attachment of multipart message due to utf-8 encoding problems!\n\n";
		}
		// Now we set the subject of the Email.
		String subject = "This is the email's subject";
		mail.setSubject(subject);
		// You'd do better than this, but I'm lazy.
		if (hasErrors) {
			mail.setBody(messageBody);
		}
		// Yep, that's it. Now we have a Email object with attachment.
		// Let's return it so we can send it in the next step.
		return mail;
}
