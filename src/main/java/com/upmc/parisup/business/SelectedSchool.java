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
	
	Long getId() {
		return this.id;
	}
	
	void setId(Long id) {
		this.id = id;
	}
	
	Long getIdSchool() {
		return this.idSchool;
	}
	
	void setIdSchool(Long id) {
		this.idSchool = id;
	}
	
	Long getIdUser() {
		return this.idUser;
	}
	
	void setIdUser(Long id) {
		this.idUser = id;
	}
}
