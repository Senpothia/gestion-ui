package com.michel.gestionui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.michel.gestionui.Constants.Constants;

@Controller
public class CompteController {
	
	@GetMapping("/creation/compte")
	public String accessCreationCompte() {
		
		
		
		return Constants.CREER_COMPTE_BANQUE;
	}
	
	
	@PostMapping("/compte/save")
	
	public String enregistrerCompte(){
		
		
		
		return Constants.ESPACE_PERSONEL;
	}

}
