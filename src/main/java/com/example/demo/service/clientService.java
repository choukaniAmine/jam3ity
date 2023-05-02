package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.client;
import com.example.demo.repositor.clientRepositor;

@Service
public class clientService {
	@Autowired
	clientRepositor rep;
	public List<client> getAll(){
		return rep.findAll();
	}
	public long save(client a) {
		client ab =new client();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setNom(a.getNom());
		ab.setPrenom(a.getPrenom());
		ab.setTel(a.getTel());
		ab.setPwd(ab.getPwd());
		return rep.save(ab).getId();
	}
	public void update(String email,client a) {
		Optional<client> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			client ab=new client();
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
		Optional<client> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<client> findByEmail(String code){
		 return rep.findByEmail(code);
}
}
