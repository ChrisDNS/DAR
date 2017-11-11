package com.upmc.parisup.business;

import java.util.Arrays;

public class User {
	private Long id;

	private String firstname, lastname, email, address, town;
	private byte[] password, salt;

	private String token;

	public User() {

	}

	public User(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public User(String firstname, String lastname, String email, String address, String town) {
		this(firstname, lastname, email);
		this.address = address;
		this.town = town;
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", town=" + town + ", password=" + Arrays.toString(password) + ", salt=" + Arrays.toString(salt) + ", token=" + token
				+ "]";
	}
}