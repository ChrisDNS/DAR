package com.upmc.parisup.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SchoolAPIHelper {
	private String s = "https://data.iledefrance.fr/api/records/1.0/search/?dataset=etablissements-denseignement-superieur";

	public void getAllData() throws IOException {

		URL url = new URL(s);
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		s += "&start=";

		int a = 19;
		int b = 1;
		s += a;

		while ((line = br.readLine()) != null && (a * b) < SchoolAPIConstants.NHINTS) {
			System.out.println(line);
			int previous_b = b;
			b++;
			System.out.println("before : " + s);
			s = s.replaceAll("&start=" + String.valueOf(a * previous_b), "&start=" + String.valueOf((a * b)));
			System.out.println("after : " + s);

			url = new URL(s);
			con = url.openConnection();
			is = con.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
		}
	}
}