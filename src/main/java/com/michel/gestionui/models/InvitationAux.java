package com.michel.gestionui.models;

public class InvitationAux {

	private Integer id;
	private CompteAux compte;
	private UtilisateurAux invite;
	private String droit;

	public InvitationAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvitationAux(Integer id, CompteAux compte, UtilisateurAux invite, String droit) {
		super();
		this.id = id;
		this.compte = compte;
		this.invite = invite;
		this.droit = droit;
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

	public UtilisateurAux getInvite() {
		return invite;
	}

	public void setInvite(UtilisateurAux invite) {
		this.invite = invite;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}

}
