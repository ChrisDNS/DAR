package com.upmc.parisup.business;

public class Message {
	private Long id;
	private Long idSchool;

	private String message, login, time;

	public Message() {

	}

	public Message(Long id, Long idSchool, String message, String login, String time) {
		super();
		this.id = id;
		this.idSchool = idSchool;
		this.message = message;
		this.login = login;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSchool() {
		return idSchool;
	}

	public void setIdSchool(Long idSchool) {
		this.idSchool = idSchool;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", idSchool=" + idSchool + ", message=" + message + ", login=" + login + ", time="
				+ time + "]";
	}
}