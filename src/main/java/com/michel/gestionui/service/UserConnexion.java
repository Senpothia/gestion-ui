package com.michel.gestionui.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.michel.gestionui.models.Login;
import com.michel.gestionui.models.Utilisateur;
import com.michel.gestionui.models.UtilisateurAux;
import com.michel.gestionui.proxy.MicroServiceGestion;

@Service
public class UserConnexion {
	
	@Autowired
	MicroServiceGestion microServiceGestion;

	public Utilisateur identifierUtilisateur(Login login, HttpSession session) {

		try {
			ResponseEntity<UtilisateurAux> userBody = microServiceGestion.generate(login);
			HttpStatus code = userBody.getStatusCode();

			UtilisateurAux userAux = userBody.getBody();

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setId(userAux.getId());
			utilisateur.setNom(userAux.getNom());
			utilisateur.setPrenom(userAux.getPrenom());
			utilisateur.setUsername(userAux.getUsername());
			utilisateur.setRole(userAux.getRole());
			utilisateur.setAutorise(userAux.isAutorise());
			utilisateur.setEnabled(userAux.isEnabled());

			String token = userAux.getToken();
			if (utilisateur.getAutorise()) {

				session.setAttribute("USER", utilisateur);
				session.setAttribute("TOKEN", token);
				String role = utilisateur.getRole();
				if (role.equals("CPROD") || role.equals("RESBE") || role.equals("BE") || role.equals("LABO")) {

					session.setAttribute("GROUPE1", true);
					session.setAttribute("GROUPE2", false);
					session.setAttribute("GROUPE3", false);
				}

				if (role.equals("CPROD") || role.equals("RESBE") || role.equals("LABO")) {

					session.setAttribute("GROUPE1", true);
					session.setAttribute("GROUPE2", true);
					session.setAttribute("GROUPE3", false);
				}

				if (role.equals("LABO")) {

					session.setAttribute("GROUPE1", true);
					session.setAttribute("GROUPE2", true);
					session.setAttribute("GROUPE3", true);
				}
			}

			return utilisateur;
		} catch (Exception e) {

			return null;
		}

	}

	public Utilisateur obtenirUtilisateur(HttpSession session, Model model) {

		Utilisateur utilisateur = (Utilisateur) session.getAttribute("USER");
		Boolean groupe1 = (Boolean) session.getAttribute("GROUPE1");
		Boolean groupe2 = (Boolean) session.getAttribute("GROUPE2");
		Boolean groupe3 = (Boolean) session.getAttribute("GROUPE3");
		
		
		if (utilisateur == null) {

			model.addAttribute("authentification", false);

		} else {

			model.addAttribute("utilisateur", utilisateur);
			model.addAttribute("authentification", true);
			model.addAttribute("groupe1", groupe1);
			model.addAttribute("groupe2", groupe2);
			model.addAttribute("groupe3", groupe3);
		}

		return utilisateur;
	}

	public Boolean confirmerUtilisateur(Login login, HttpSession session) {

		try {
			ResponseEntity<UtilisateurAux> userBody = microServiceGestion.generate(login);
			HttpStatus code = userBody.getStatusCode();

			UtilisateurAux userAux = userBody.getBody();

			String tokenToBeTested = userAux.getToken();

			String tokenSession = (String) session.getAttribute("TOKEN");
			if (tokenToBeTested.equals(tokenSession)) {
				return true;
			} else {

				return false;

			}

		} catch (Exception e) {

			return false;
		}

	}

}
