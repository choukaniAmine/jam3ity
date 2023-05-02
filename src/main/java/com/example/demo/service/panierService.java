package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.panier;
import com.example.demo.repositor.panierRepositor;


@Service
public class panierService {
	@Autowired
	panierRepositor rep;
	public List<panier> getAll(){
		return rep.findAll();
	}
	public long save(panier a) {
		panier ab =new panier();
		ab.setId(a.getId());
		ab.setLibelle(a.getLibelle());
		ab.setPath(a.getPath());
		ab.setPrix(a.getPrix());
		ab.setTotal(a.getTotal());
		return rep.save(ab).getId();
	}
	public void update(Long code,panier a) {
		Optional<panier> abn=rep.findById(code);
		if(abn.isPresent()) {
			panier ab=new panier();
			ab.setId(a.getId());
			ab.setLibelle(a.getLibelle());
			ab.setPath(a.getPath());
			ab.setPrix(a.getPrix());
			ab.setTotal(a.getTotal());
			rep.save(ab);
		}
	}
	public void delete(Long code) {
		Optional<panier> ab=rep.findById(code);
		ab.ifPresent(rep::delete);
	}
}
