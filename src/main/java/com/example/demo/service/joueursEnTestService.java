package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.joueursEnTest;
import com.example.demo.repositor.joueursEnTestRepositor;


@Service
public class joueursEnTestService {
	@Autowired
	joueursEnTestRepositor rep;
	public List<joueursEnTest> getAll(){
		return rep.findAll();
	}
	public long save(joueursEnTest a) {
		joueursEnTest ab =new joueursEnTest();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setTel(a.getTel());
		ab.setDateDeNaissance(a.getDateDeNaissance());
		ab.setPoste(a.getPoste());
		ab.setDatetest(a.getDatetest());
		return rep.save(ab).getId();
	}
	public void update(String email,joueursEnTest a) {
		Optional<joueursEnTest> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			joueursEnTest ab=new joueursEnTest();
			ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setDateDeNaissance(a.getDateDeNaissance());
			ab.setPoste(a.getPoste());
			ab.setDatetest(a.getDatetest());
			rep.save(ab);
		}
	}
	public void delete(String email) {
		Optional<joueursEnTest> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<joueursEnTest> findByEmail(String code){
		 return rep.findByEmail(code);
}
}
