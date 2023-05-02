package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entraineur;
import com.example.demo.repositor.entraineurRepositor;


@Service
public class entraineurService {
	@Autowired
	entraineurRepositor rep;
	public List<entraineur> getAll(){
		return rep.findAll();
	}
	public long save(entraineur a) {
		entraineur ab =new entraineur();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setTel(a.getTel());
		ab.setPwd(ab.getPwd());
		return rep.save(ab).getId();
	}
	public void update(String email,entraineur a) {
		Optional<entraineur> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			entraineur ab=new entraineur();
			ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setPwd(ab.getPwd());
			rep.save(ab);
		}
	}
	public void delete(String email) {
		Optional<entraineur> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<entraineur> findByEmail(String code){
		 return rep.findByEmail(code);
}
}
