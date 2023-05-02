package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.joueurs;
import com.example.demo.repositor.joueursRepositor;


@Service
public class joueursService {
	@Autowired
	joueursRepositor rep;
	public List<joueurs> getAll(){
		return rep.findAll();
	}
	public long save(joueurs a) {
		joueurs ab =new joueurs();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setTel(a.getTel());
		ab.setDateDeNaissance(a.getDateDeNaissance());
		ab.setPoste(a.getPoste());
		
		return rep.save(ab).getId();
	}
	public void update(String email,joueurs a) {
		Optional<joueurs> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			joueurs ab=new joueurs();
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
		Optional<joueurs> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<joueurs> findByEmail(String code){
		 return rep.findByEmail(code);
}
}
