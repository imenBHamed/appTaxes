package com.app.entities;

import java.io.Serializable;
import java.util.Collection;

 
public class Entreprise implements Serializable{
	private long code;
	private String nom;
	private String email;
	private String raisonSociale;
	private Collection<Taxe> taxes;
	public Entreprise() {
		super();
	}
	public Entreprise(String nom, String email, String raisonSociale) {
		super();
		this.nom = nom;
		this.email = email;
		this.raisonSociale = raisonSociale;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public Collection<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(Collection<Taxe> taxes) {
		this.taxes = taxes;
	}

}
