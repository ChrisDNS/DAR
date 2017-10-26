package com.upmc.darproject.business;

public class School {
	private Long id;

	private String university, name, type, acronym, address, city, postcode, academy, status;
	private double lon, lat;

	public School() {

	}

	public School(Long id, String university, String name, String type, String acronym, String address, String city,
			String postcode, String academy, String status, double lon, double lat) {
		super();
		this.id = id;
		this.university = university;
		this.name = name;
		this.type = type;
		this.acronym = acronym;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
		this.academy = academy;
		this.status = status;
		this.lon = lon;
		this.lat = lat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", university=" + university + ", name=" + name + ", type=" + type + ", acronym="
				+ acronym + ", address=" + address + ", city=" + city + ", postcode=" + postcode + ", academy="
				+ academy + ", status=" + status + ", lon=" + lon + ", lat=" + lat + "]";
	}
}