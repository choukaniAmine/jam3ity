package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abonnement")
public class abonnement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	private String code;
	private int qte;
	private String libelle;
	private String image;
	private float prix;
	private String details;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	
	@Override
	public String toString() {
		return "abonnement [id=" + id + ", code=" + code + ", qte=" + qte + ", libelle=" + libelle + ", image=" + image
				+ ", prix=" + prix + ", details=" + details + "]";
	}
	public abonnement(long id, String code, int qte, String libelle, String image, float prix, String details) {
		super();
		this.id = id;
		this.code = code;
		this.qte = qte;
		this.libelle = libelle;
		this.image = image;
		this.prix = prix;
		this.details = details;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
