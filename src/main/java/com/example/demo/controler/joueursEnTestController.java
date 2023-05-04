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

import com.example.demo.model.joueursEnTest;

import com.example.demo.repositor.joueursEnTestRepositor;

import com.example.demo.service.joueursEnTestService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class joueursEnTestController {
	 @Autowired
	    private joueursEnTestService ser;
	 @Autowired
	 private joueursEnTestRepositor rep;
	 @GetMapping("/joueursEnTest")
	    public List<joueursEnTest> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/joueursEnTest/{id}")
	 public ResponseEntity<joueursEnTest> post(@PathVariable String id){
	 			 			

	Optional<joueursEnTest> cat=ser.findByEmail(id);
	return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
	    }
	 @PostMapping("/joueursEnTest")
	    public long save(@RequestBody joueursEnTest cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/joueursEnTest/{id}")      
		   public ResponseEntity<joueursEnTest> update(@PathVariable long id, @RequestBody joueursEnTest a) {
			   joueursEnTest ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
				ab.setId(a.getId());
				ab.setEmail(a.getEmail());
				ab.setNom(a.getNom());
				ab.setPrenom(a.getPrenom());
				ab.setTel(a.getTel());
				ab.setDateDeNaissance(a.getDateDeNaissance());
				ab.setPoste(a.getPoste());
				ab.setDatetest(a.getDatetest());
				joueursEnTest catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/joueursEnTest/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
