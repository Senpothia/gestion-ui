package com.michel.gestionui.proxy;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


import com.michel.gestionui.models.CompteAux;

public interface ProxyGestion {
	
	
	@GetMapping("/get/comptes/{userId}")
	List<CompteAux> getComptes(@RequestHeader("Authorization") String token, @PathVariable("userId") Integer userId);
	
	@PostMapping("/compte/save")
	void creerCompteBancaire(@RequestHeader("Authorization") String token, @RequestBody CompteAux compte);
	
	@GetMapping("/get/compte/{idCompte}")
	CompteAux getCompte(@RequestHeader("Authorization") String token, @PathVariable("idCompte") Integer idCompte);

}
