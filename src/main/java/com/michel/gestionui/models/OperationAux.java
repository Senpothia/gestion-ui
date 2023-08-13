package com.michel.gestionui.models;

import java.time.LocalDateTime;

public class OperationAux {

	private Integer id;
	private CompteAux compte;
	private float montant;
	private CategorieAux categorie;
	private String nomCategorie;
	private LocalDateTime date;
	private String stringDate;
	private Integer idCompte;

	public OperationAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public OperationAux(Integer id, CompteAux compte, float montant, CategorieAux categorie, String nomCategorie,
			LocalDateTime date, String stringDate, Integer idCompte) {
		super();
		this.id = id;
		this.compte = compte;
		this.montant = montant;
		this.categorie = categorie;
		this.nomCategorie = nomCategorie;
		this.date = date;
		this.stringDate = stringDate;
		this.idCompte = idCompte;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompteAux getCompte() {
		return compte;
	}

	public void setCompte(CompteAux compte) {
		this.compte = compte;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public CategorieAux getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieAux categorie) {
		this.categorie = categorie;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}



	public String getNomCategorie() {
		return nomCategorie;
	}



	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	

}
