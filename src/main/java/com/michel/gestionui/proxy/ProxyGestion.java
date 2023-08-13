package com.michel.gestionui.proxy;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.michel.gestionui.models.CategorieAux;
import com.michel.gestionui.models.CompteAux;
import com.michel.gestionui.models.OperationAux;

public interface ProxyGestion {
	
	
	@GetMapping("/get/comptes/{userId}")
	List<CompteAux> getComptes(@RequestHeader("Authorization") String token, @PathVariable("userId") Integer userId);
	
	@PostMapping("/compte/save")
	void creerCompteBancaire(@RequestHeader("Authorization") String token, @RequestBody CompteAux compte);
	
	@GetMapping("/get/compte/{idCompte}")
	CompteAux getCompte(@RequestHeader("Authorization") String token, @PathVariable("idCompte") Integer idCompte);
	
	
	@GetMapping("/compte/ajouter/operations/{id}")
	List<OperationAux> getOperationsByAccount(@RequestHeader("Authorization") String token, @PathVariable("id")Integer id);
	
	@PostMapping("/operation/ajouter/{idCompte}")
	void ajouterOperation(@RequestHeader("Authorization") String token, @RequestBody OperationAux operation, @PathVariable("idCompte")Integer idCompte);
	
	
	@GetMapping("/categories/get/all")
	List<String> getAllNomsCategories(@RequestHeader("Authorization") String token);
	
	@GetMapping("/operation/modifier/{id}")
	OperationAux getOperationsById(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id);
	
	@PostMapping("/operation/modifier/{id}")
	void modifyOperation(@RequestHeader("Authorization") String token, @RequestBody OperationAux operation, @PathVariable("id") Integer id);
}
 