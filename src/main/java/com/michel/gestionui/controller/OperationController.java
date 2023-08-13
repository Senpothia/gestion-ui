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
import com.michel.gestionui.models.CategorieAux;
import com.michel.gestionui.models.CompteAux;
import com.michel.gestionui.models.OperationAux;
import com.michel.gestionui.models.Utilisateur;
import com.michel.gestionui.proxy.MicroServiceGestion;
import com.michel.gestionui.service.UserConnexion;

@Controller
public class OperationController {

	@Autowired
	private MicroServiceGestion microServiceGestion;

	@Autowired
	private UserConnexion userConnexion;

	@GetMapping("/compte/ajouter/operations/{idCompte}")
	public String accessOperationForm(Model model, HttpSession session, @PathVariable("idCompte") Integer idCompte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			List<String> categories = microServiceGestion.getAllNomsCategories(token);

			model.addAttribute("operation", new OperationAux());
			model.addAttribute("categories", categories);
			model.addAttribute("compte", idCompte);

			return Constants.CREATION_OPERATION;

		}

	}

	@PostMapping("/operation/ajouter/{idCompte}")
	public String processOperationForm(Model model, HttpSession session, @PathVariable("idCompte") Integer idCompte,
			OperationAux operation) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			operation.setIdCompte(idCompte);
			microServiceGestion.ajouterOperation(token, operation, idCompte);

			return Constants.ESPACE_PERSONEL;

		}
	}

	@GetMapping("/compte/operations/{idCompte}")
	public String getOperationsByAccount(Model model, HttpSession session, @PathVariable("idCompte") Integer idCompte) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			boolean vide = false;
			String token = Constants.getToken(session);
			List<OperationAux> operations = microServiceGestion.getOperationsByAccount(token, idCompte);
			CompteAux compte = microServiceGestion.getCompte(token, idCompte);

			if (operations.isEmpty()) {

				vide = true;
			}
			model.addAttribute("operations", operations);
			model.addAttribute("compte", compte);
			model.addAttribute("vide", vide);
			return Constants.OPERATIONS;

		}
	}

	@GetMapping("/operation/modifier/{id}")
	public String accessModificationOperation(Model model, HttpSession session, @PathVariable("id") Integer id) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {

			String token = Constants.getToken(session);
			OperationAux operation = microServiceGestion.getOperationsById(token, id);
			List<String> categories = microServiceGestion.getAllNomsCategories(token);

			model.addAttribute("operation", operation);
			model.addAttribute("compte", operation.getCompte());
			model.addAttribute("categories", categories);

			System.out.println("Operation montant: " + operation.getMontant());
			System.out.println("Compte nom: " + operation.getCompte().getNom());

			return Constants.MODIFIER_OPERATION;

		}

	}

	@PostMapping("/operation/modifier/{id}")
	public String modififyOperation(Model model, HttpSession session, OperationAux operation, @PathVariable("id") Integer id) {

		Utilisateur utilisateur = userConnexion.obtenirUtilisateur(session, model);
		if (utilisateur == null) {
			return "redirect:/connexion";
		} else {
			
			operation.setId(id);
			String token = Constants.getToken(session);
			microServiceGestion.modifyOperation(token, operation, id);

			return Constants.ESPACE_PERSONEL;

		}

	}

}
