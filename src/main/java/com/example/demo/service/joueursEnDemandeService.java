package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.joueursEnDemande;
import com.example.demo.repositor.joueursEnDemandeRepositor;


@Service
public class joueursEnDemandeService {
	@Autowired
	joueursEnDemandeRepositor rep;
	public List<joueursEnDemande> getAll(){
		return rep.findAll();
	}
	public long save(joueursEnDemande a) {
		joueursEnDemande ab =new joueursEnDemande();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setTel(a.getTel());
		ab.setDateDeNaissance(a.getDateDeNaissance());
		ab.setPoste(a.getPoste());
		
		return rep.save(ab).getId();
	}
	public void update(String email,joueursEnDemande a) {
		Optional<joueursEnDemande> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			joueursEnDemande ab=new joueursEnDemande();
			ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setDateDeNaissance(a.getDateDeNaissance());
			ab.setPoste(a.getPoste());
			rep.save(ab);
		}
	}
	public void delete(String email) {
		Optional<joueursEnDemande> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<joueursEnDemande> findByEmail(String code){
		 return rep.findByEmail(code);
}
}