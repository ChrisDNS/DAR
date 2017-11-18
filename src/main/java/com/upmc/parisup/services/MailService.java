package com.upmc.parisup.services;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * Sending mail service doesn't work with Heroku
 *
 */
public class MailService {
	private static final int PORT = 587;
	private static final String FROM = "noreply@parisup.com";

	private String message, url;

	/**
	 * Constructor MailService with message content and change password hyperlink
	 * 
	 * @param message
	 * @param url
	 */
	public MailService(String message, String url) {
		super();
		this.message = message;
		this.url = url;
	}

	/**
	 * Sends SMTP email to email argument
	 * 
	 * @param email
	 */
	public void sendTo(String email) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", Integer.toString(PORT));

		InternetAddress from = null;

		try {
			from = new InternetAddress("genielogiciel2017@gmail.com", FROM);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {

			Session sess = Session.getInstance(props, new javax.mail.Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					// return new PasswordAuthentication("blabla@gmail.com", "blabla");
					return null;
				}
			});

			String html = message + "\n<a href='" + url + "'>" + url + "</a>";

			Message m = new MimeMessage(sess);
			m.setFrom(from);
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			m.setSubject("Mot de passe oubli��");
			m.setContent(html, "text/html; charset=utf-8");

			Transport.send(m);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}