package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.entraineur;

import com.example.demo.repositor.entraineurRepositor;

import com.example.demo.service.entraineurService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class entraineurController {
	 @Autowired
	    private entraineurService ser;
	 @Autowired
	 private entraineurRepositor rep;
	 @GetMapping("/entraineur")
	    public List<entraineur> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/entraineur/{id}")
	 public ResponseEntity<entraineur> post(@PathVariable String id){
	 			Optional<entraineur> cat=ser.findByEmail(id);
	 			return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/entraineur")
	    public long save(@RequestBody entraineur cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/entraineur/{id}")      
		   public ResponseEntity<entraineur> update(@PathVariable long id, @RequestBody entraineur a) {
		       entraineur ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
		   	ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setPwd(ab.getPwd());
		   entraineur catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/entraineur/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
