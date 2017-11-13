package com.upmc.parisup.business;

public class SelectedSchool {
	private Long id;

	private Long idSchool, idUser;

	public SelectedSchool() {

	}

	public SelectedSchool(Long idSchool, Long idUser) {
		super();
		this.idSchool = idSchool;
		this.idUser = idUser;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSchool() {
		return this.idSchool;
	}

	public void setIdSchool(Long id) {
		this.idSchool = id;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long id) {
		this.idUser = id;
	}
}