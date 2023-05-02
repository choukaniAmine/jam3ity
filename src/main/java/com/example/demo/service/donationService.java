package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.donation;
import com.example.demo.repositor.donationRepositor;


@Service
public class donationService {
	@Autowired
	donationRepositor rep;
	public List<donation> getAll(){
		return rep.findAll();
	}
	public long save(donation a) {
		donation ab =new donation();
		ab.setId(a.getId());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setPrix(ab.getPrix());
		return rep.save(ab).getId();
	}
	public void update(Long id,donation a) {
		Optional<donation> abn=rep.findById(id);
		if(abn.isPresent()) {
			donation ab=new donation();
			ab.setId(a.getId());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setPrix(ab.getPrix());
			rep.save(ab);
		}
	}
	public void delete(Long id) {
		Optional<donation> ab=rep.findById(id);
		ab.ifPresent(rep::delete);
	}
}
