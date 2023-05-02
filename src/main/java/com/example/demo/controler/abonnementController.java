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


import com.example.demo.model.abonnement;


import com.example.demo.repositor.abonnementRepositor;
import com.example.demo.service.abonnementService;

;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class abonnementController {
	 @Autowired
	    private abonnementService ser;
	 @Autowired
	 private abonnementRepositor rep;
	 @GetMapping("/abonnement")
	    public List<abonnement> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/abonnement/{id}")
	 public ResponseEntity<abonnement> post(@PathVariable String id){
	 			Optional<abonnement> cat=ser.findByCode(id);
	 			return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/abonnement")
	    public long save(@RequestBody abonnement cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/abonnement/{id}")      
		   public ResponseEntity<abonnement> update(@PathVariable long id, @RequestBody abonnement a) {
		       abonnement ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
		     
				ab.setId(a.getId());
				ab.setImage(a.getImage());
				ab.setLibelle(a.getImage());
				ab.setCode(a.getCode());
				ab.setQte(a.getQte());
		    abonnement catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/abonnement/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
