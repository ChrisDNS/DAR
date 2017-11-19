package com.upmc.parisup.business;

/**
 * 
 * Rating job
 *
 */
public class Rating {
	private Long id;

	private Long idSchool, idUser;
	private String nameUser;
	private String comment;
	private Long rating;
	private String date;

	public Rating() {

	}

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////

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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", idSchool=" + idSchool + ", idUser=" + idUser + ", nameUser=" + nameUser
				+ ", comment=" + comment + ", rating=" + rating + ", date=" + date + "]";
	}
}