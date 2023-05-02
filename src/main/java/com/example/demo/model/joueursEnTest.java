package com.example.demo.model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="joueursEnTest")

	public class joueursEnTest{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		 private long id;
		private String nom;
		private String prenom;
		private Date dateDeNaissance;
		private String poste;  
		private String tel;
		private String email;
		private Date datetest;
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
		public Date getDateDeNaissance() {
			return dateDeNaissance;
		}
		public void setDateDeNaissance(Date dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}
		public String getPoste() {
			return poste;
		}
		public void setPoste(String poste) {
			this.poste = poste;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public Date getDatetest() {
			return datetest;
		}
		public void setDatetest(Date datetest) {
			this.datetest = datetest;
		}

		public joueursEnTest(long id, String nom, String prenom, Date dateDeNaissance, String poste, String tel,
				String email, Date datetest) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.dateDeNaissance = dateDeNaissance;
			this.poste = poste;
			this.tel = tel;
			this.email = email;
			this.datetest = datetest;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public joueursEnTest() {
			super();
			// TODO Auto-generated constructor stub
		}


		
}
