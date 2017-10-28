package com.upmc.parisup.api.schools;


/**
 * 
 * Open Data Schools in Ile-de-France API
 *
 */
public class SchoolAPIConstants {

	private SchoolAPIConstants() {

	}
	
	public static final String URL = "https://data.iledefrance.fr/api/records/1.0/search/";
	public static final String DATASET = "etablissements-denseignement-superieur";
	public static final int NHINTS = 722;
	
	public static final String ROWS = "rows";
	public static final int PAGE_SIZE = 20;
	
	public static final String START = "start";
	public static final String Q = "q";
	
	public static final String RECORDS = "records";
	public static final String FIELDS = "fields";
}