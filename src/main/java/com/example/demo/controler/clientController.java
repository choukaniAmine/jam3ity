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


import com.example.demo.model.client;

import com.example.demo.repositor.clientRepositor;

import com.example.demo.service.clientService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class clientController {
	 @Autowired
	    private clientService ser;
	 @Autowired
	 private clientRepositor rep;
	 @GetMapping("/client")
	    public List<client> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/client/{id}")
	 public ResponseEntity<client> post(@PathVariable String id){
	 			Optional<client> cat=ser.findByEmail(id);
	 			return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/client")
	    public long save(@RequestBody client cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/client/{id}")      
		   public ResponseEntity<client> update(@PathVariable long id, @RequestBody client a) {
		       client ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
		   	ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setPwd(ab.getPwd());
		    client catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/client/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
