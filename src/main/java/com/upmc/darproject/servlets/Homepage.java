package com.upmc.darproject.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.darproject.services.FillDB;

public class Homepage extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");

		String s = "https://data.iledefrance.fr/api/records/1.0/search/?dataset=etablissements-denseignement-superieur";

		try {
			FillDB.addUsers();

			URL url;
			try {
				url = new URL(s);
				URLConnection con = url.openConnection();
				InputStream is = con.getInputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String line = null;
				s += "&start=";
				
				int a = 19;
				int b = 1;
				int i = 1;

				while ((line = br.readLine()) != null) {
					System.out.println(line);
					s+= a * b;
					url = new URL(s);
					con = url.openConnection();
					is = con.getInputStream();

					br = new BufferedReader(new InputStreamReader(is));
					line = line.replaceAll(String.valueOf(a*b), String.valueOf((a*b)*i));
					i++;
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}