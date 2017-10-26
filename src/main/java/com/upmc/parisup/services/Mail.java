package com.upmc.parisup.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class Mail {
	private static final String HOST = "smtp.googlemail.com";
	private static final int PORT = 465;
	private static final String FROM = "noreply@parisup.com";

	public void sendTo(String address) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(HOST);
			email.setSmtpPort(PORT);
			email.setAuthenticator(new DefaultAuthenticator("genielogiciel2017@gmail.com", "mccmrogenie"));
			email.setSSL(true);
			email.setFrom(FROM);
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo(address);
			email.send();

		} catch (Exception ex) {
			System.out.println("Unable to send email");
			System.out.println(ex);
		}
	}
}