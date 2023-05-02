package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="entraineur")
public class entraineur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	private String nom;
	private String prenom;
	private String email;
	private String pwd;
	private String tel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "entraineur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pwd=" + pwd
				+ ", tel=" + tel + "]";
	}
	public entraineur(long id, String nom, String prenom, String email, String pwd, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
	}
	public entraineur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
