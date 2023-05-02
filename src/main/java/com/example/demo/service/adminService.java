package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.admin;

import com.example.demo.repositor.adminRepositor;


@Service
public class adminService {
	@Autowired
	adminRepositor rep;
	public List<admin> getAll(){
		return rep.findAll();
	}
	public long save(admin a) {
		admin ab =new admin();
		ab.setId(a.getId());
		ab.setEmail(a.getEmail());
		ab.setPwd(ab.getPwd());
		return rep.save(ab).getId();
	}
	public void update(String email,admin a) {
		Optional<admin> abn=rep.findByEmail(email);
		if(abn.isPresent()) {
			admin ab=new admin();
			ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setPwd(ab.getPwd());
			rep.save(ab);
		}
	}
	public void delete(String email) {
		Optional<admin> ab=rep.findByEmail(email);
		ab.ifPresent(rep::delete);
	}
	 public Optional<admin> findByEmail(String code){
		 return rep.findByEmail(code);
	 }
}
