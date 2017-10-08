package com.upmc.darproject.business;

public class User {
	private Long id;
	
	private String firstname, lastname;
	private String login, password, salt;

	public User() {
	}

	public User(String firstname, String lastname, String login, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
//		this.salt = Util.generateSalt();
//		this.password = Util.hashPass(password + salt);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", login=" + login
				+ ", password=" + password + ", salt=" + salt + "]";
	}
}