package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="panier")
public class panier {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String libelle;
private String path;
private float prix;
private float total;
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
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
@Override
public String toString() {
	return "panier [id=" + id + ", libelle=" + libelle + ", path=" + path + ", prix=" + prix + ", total=" + total + "]";
}
public panier(long id, String libelle, String path, float prix, float total) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.path = path;
	this.prix = prix;
	this.total = total;
}
public panier() {
	super();
	// TODO Auto-generated constructor stub
}

}
