package com.michel.gestionui.Constants;

import javax.servlet.http.HttpSession;

public class Constants {

	public static final String PAGE_ACCUEIL = "accueil";
	public static final String AIDE = "aide";
	public static final String PRESENTATION = "presentation";
	public static final String CONNEXION = "connexion";
	public static final String CREATION_COMPTE = "creerCompte";
	public static final String ESPACE_PERSONEL = "espace";
	public static final String MODIFIER_COMPTE = "modifierCompte";
	public static final String ALERTE_BLOCAGE = "alerteBlocage";
	public static final String CREER_COMPTE_BANQUE = "creerCompteBanque";
	public static final String COMPTES = "comptes";
	public static final String COMPTE = "compte";
	public static final String OPERATIONS = "operations";
	public static final String CREATION_OPERATION = "creerOperation";
	public static final String MODIFIER_OPERATION = "modifierOperation";
	
	
	public static String getToken(HttpSession session) {

		String token = (String) session.getAttribute("TOKEN");
		token = "Bearer " + token;
		return token;
	}

}
