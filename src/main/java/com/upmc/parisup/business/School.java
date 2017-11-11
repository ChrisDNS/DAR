package com.upmc.parisup.business;

import java.util.Arrays;

public class School {
	private Long id;

	private String departement, code_uai, lien_site_onisep_fr, statut, commune, adresse, longitude_x,
			type_d_etablissement, tutelle, universite, nom, cp, academie, sigle, latitude_y;
	private String[] x_y;

	public School() {

	}

	public School(Long id, String departement, String code_uai, String lien_site_onisep_fr, String statut,
			String commune, String adresse, String longitude_x, String type_d_etablissement, String tutelle,
			String universite, String nom, String cp, String academie, String sigle, String latitude_y, String[] x_y) {
		super();
		this.id = id;
		this.departement = departement;
		this.code_uai = code_uai;
		this.lien_site_onisep_fr = lien_site_onisep_fr;
		this.statut = statut;
		this.commune = commune;
		this.adresse = adresse;
		this.longitude_x = longitude_x;
		this.type_d_etablissement = type_d_etablissement;
		this.tutelle = tutelle;
		this.universite = universite;
		this.nom = nom;
		this.cp = cp;
		this.academie = academie;
		this.sigle = sigle;
		this.latitude_y = latitude_y;
		this.x_y = x_y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getCode_uai() {
		return code_uai;
	}

	public void setCode_uai(String code_uai) {
		this.code_uai = code_uai;
	}

	public String getLien_site_onisep_fr() {
		return lien_site_onisep_fr;
	}

	public void setLien_site_onisep_fr(String lien_site_onisep_fr) {
		this.lien_site_onisep_fr = lien_site_onisep_fr;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLongitude_x() {
		return longitude_x;
	}

	public void setLongitude_x(String longitude_x) {
		this.longitude_x = longitude_x;
	}

	public String getType_d_etablissement() {
		return type_d_etablissement;
	}

	public void setType_d_etablissement(String type_d_etablissement) {
		this.type_d_etablissement = type_d_etablissement;
	}

	public String getTutelle() {
		return tutelle;
	}

	public void setTutelle(String tutelle) {
		this.tutelle = tutelle;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getAcademie() {
		return academie;
	}

	public void setAcademie(String academie) {
		this.academie = academie;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getLatitude_y() {
		return latitude_y;
	}

	public void setLatitude_y(String latitude_y) {
		this.latitude_y = latitude_y;
	}

	public String[] getX_y() {
		return x_y;
	}

	public void setX_y(String[] x_y) {
		this.x_y = x_y;
	}

	@Override
	public String toString() {
		return ((this.type_d_etablissement.equals("Unité de formation et de recherche")) ? this.universite + " - " : "") + this.nom;
		/*
		return "School [id=" + id + ", departement=" + departement + ", code_uai=" + code_uai + ", lien_site_onisep_fr="
				+ lien_site_onisep_fr + ", statut=" + statut + ", commune=" + commune + ", adresse=" + adresse
				+ ", longitude_x=" + longitude_x + ", type_d_etablissement=" + type_d_etablissement + ", tutelle="
				+ tutelle + ", universite=" + universite + ", nom=" + nom + ", cp=" + cp + ", academie=" + academie
				+ ", sigle=" + sigle + ", latitude_y=" + latitude_y + ", x_y=" + Arrays.toString(x_y) + "]";
		 */
	}
}