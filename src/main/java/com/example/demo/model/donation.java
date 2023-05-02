package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donation")
public class donation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	private String nom;
	private String prenom;
	private float prix;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "donation [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", prix=" + prix + "]";
	}
	public donation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public donation(long id, String nom, String prenom, float prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.prix = prix;
	}
	
}
