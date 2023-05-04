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


import com.example.demo.model.donation;

import com.example.demo.repositor.donationRepositor;

import com.example.demo.service.donationService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class donationController {
	 @Autowired
	    private donationService ser;
	 @Autowired
	 private donationRepositor rep;
	 @GetMapping("/donation")
	    public List<donation> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/donation/{id}")
	 public ResponseEntity<donation> post(@PathVariable Long id){
	 			Optional<donation> cat=rep.findById(id);
	 			return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/donation")
	    public long save(@RequestBody donation cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/donation/{id}")      
		   public ResponseEntity<donation> update(@PathVariable long id, @RequestBody donation a) {
		       donation ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
		   	ab.setId(a.getId());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setPrix(ab.getPrix());
		    donation catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/donation/{id}")
		   public void delete(@PathVariable Long id) {
		       ser.delete(id);
		   }
}
