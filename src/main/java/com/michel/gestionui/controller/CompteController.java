package com.michel.gestionui.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.michel.gestionui.Constants.Constants;
import com.michel.gestionui.models.CompteAux;
import com.michel.gestionui.models.Utilisateur;
import com.michel.gestionui.proxy.MicroServiceGestion;
import com.michel.gestionui.service.UserConnexion;

@Controller
public class CompteController {

	@Autowired
	private MicroServiceGestion microServiceGestion;

	@Autowired
	private UserConnexion userConnexion;

	@GetMapping("/creation/compte")
	public String accessCreationCompte(Model model, HttpSession session) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		model.addAttribute("compte", new CompteAux());
		return Constants.CREER_COMPTE_BANQUE;
	}

	@PostMapping("/compte/save")
	public String enregistrerCompte(Model model, HttpSession session, CompteAux compte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			compte.setProprietaire(utilisateur.getId());
			microServiceGestion.creerCompteBancaire(token, compte);
			return Constants.ESPACE_PERSONEL;

		}

	}

	@GetMapping("/get/comptes")
	public String getComptes(Model model, HttpSession session) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			boolean vide = false;
			List<CompteAux> comptes = microServiceGestion.getComptes(token, utilisateur.getId());
			if (comptes.isEmpty()) {

				vide = true;
			}
			model.addAttribute("comptes", comptes);
			model.addAttribute("vide", vide);

			return Constants.COMPTES;

		}

	}

	@GetMapping("/compte/voir/{idCompte}")
	public String voirCompte(Model model, HttpSession session, @PathVariable("idCompte") Integer idCompte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			CompteAux compte = microServiceGestion.getCompte(token, idCompte);
			model.addAttribute("compte", compte);
			
			return Constants.COMPTE;

		}
	}
	
	
	@GetMapping("/compte/modifier/{idCompte}")
	public String modifierCompte(Model model, HttpSession session, @PathVariable("idCompte") Integer idCompte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			CompteAux compte = microServiceGestion.getCompte(token, idCompte);
			model.addAttribute("compte", compte);
			
			return Constants.MODIFIER_COMPTE_BANCAIRE;

		}
	}
	
	
	@PostMapping("/compte/modifier/{id}")
	public String modifierCompte(Model model, HttpSession session, CompteAux compte, @PathVariable("id") Integer idCompte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			compte.setProprietaire(utilisateur.getId());
			compte.setId(idCompte);
			microServiceGestion.modifierCompteBancaire(token, compte);
			return Constants.ESPACE_PERSONEL;

		}

	}


}
