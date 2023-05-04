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



import com.example.demo.repositor.joueursEnDemandeRepositor;

import com.example.demo.service.joueursEnDemandeService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class joueursEnDemande {
	 @Autowired
	    private joueursEnDemandeService ser;
	 @Autowired
	 private joueursEnDemandeRepositor rep;
	 @GetMapping("/joueursEnDemande")
	    public List<com.example.demo.model.joueursEnDemande> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/joueursEnDemande/{id}")
	 public ResponseEntity<com.example.demo.model.joueursEnDemande> post(@PathVariable String id){
	 			 		
	Optional<com.example.demo.model.joueursEnDemande> cat=ser.findByEmail(id);
	return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/joueursEnDemande")
	    public long save(@RequestBody com.example.demo.model.joueursEnDemande cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/joueursEnDemande/{id}")      
		   public ResponseEntity<com.example.demo.model.joueursEnDemande> update(@PathVariable long id, @RequestBody com.example.demo.model.joueursEnDemande a) {
			   com.example.demo.model.joueursEnDemande ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
				ab.setId(a.getId());
				ab.setEmail(a.getEmail());
				ab.setNom(a.getNom());
				ab.setPrenom(a.getPrenom());
				ab.setTel(a.getTel());
				ab.setDateDeNaissance(a.getDateDeNaissance());
				ab.setPoste(a.getPoste());
				com.example.demo.model.joueursEnDemande catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/joueursEnDemande/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
