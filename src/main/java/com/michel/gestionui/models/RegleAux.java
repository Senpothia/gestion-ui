package com.michel.gestionui.models;

public class RegleAux {

	private Integer id;
	private CompteAux compte;
	private CategorieAux categorie;
	private float valeur;

	public RegleAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegleAux(Integer id, CompteAux compte, CategorieAux categorie, float valeur) {
		super();
		this.id = id;
		this.compte = compte;
		this.categorie = categorie;
		this.valeur = valeur;
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

	public CategorieAux getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieAux categorie) {
		this.categorie = categorie;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

}
