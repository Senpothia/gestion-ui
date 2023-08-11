package com.michel.gestionui.models;

import java.util.List;

public class CategorieAux {

	private Integer id;
	private String nom;
	private List<OperationAux> operations;

	public CategorieAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieAux(Integer id, String nom, List<OperationAux> operations) {
		super();
		this.id = id;
		this.nom = nom;
		this.operations = operations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<OperationAux> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationAux> operations) {
		this.operations = operations;
	}

}
