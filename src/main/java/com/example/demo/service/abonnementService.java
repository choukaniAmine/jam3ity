package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.abonnement;

import com.example.demo.repositor.abonnementRepositor;

@Service
public class abonnementService {
	@Autowired
	abonnementRepositor rep;
	public List<abonnement> getAll(){
		return rep.findAll();
	}
	public long save(abonnement a) {
		abonnement ab =new abonnement();
		ab.setId(a.getId());
		ab.setImage(a.getImage());
		ab.setLibelle(a.getImage());
		ab.setCode(a.getCode());
		ab.setQte(a.getQte());
		ab.setDetails(a.getDetails());
		ab.setPrix(a.getPrix());
		return rep.save(ab).getId();
	}
	public void update(String code,abonnement a) {
		Optional<abonnement> abn=rep.findByCode(code);
		if(abn.isPresent()) {
			abonnement ab=new abonnement();
			ab.setId(a.getId());
			ab.setImage(a.getImage());
			ab.setLibelle(a.getImage());
			ab.setCode(a.getCode());
			ab.setQte(a.getQte());
			rep.save(ab);
		}
	}
	public void delete(String code) {
		Optional<abonnement> ab=rep.findByCode(code);
		ab.ifPresent(rep::delete);
	}
	 public Optional<abonnement> findByCode(String code){
		 return rep.findByCode(code);
	 }
}
