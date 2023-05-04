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

import com.example.demo.model.panier;

import com.example.demo.repositor.panierRepositor;

import com.example.demo.service.panierService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class panierController {
	@Autowired
    private panierService ser;
 @Autowired
 private panierRepositor rep;
 @GetMapping("/panier")
    public List<panier> list() {
	
             return ser.getAll();
   }
 	 
 @GetMapping("/panier/{id}")
 public ResponseEntity<panier> post(@PathVariable Long id){
 			 			

Optional<panier> cat=rep.findById(id);
return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }
 @PostMapping("/panier")
    public long save(@RequestBody panier cat) {
	 
        return ser.save(cat);
    }
 @PutMapping("/panier/{id}")      
	   public ResponseEntity<panier> update(@PathVariable long id, @RequestBody panier a) {
		   panier ab = rep.findById(id)
	    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
		   ab.setId(a.getId());
			ab.setLibelle(a.getLibelle());
			ab.setPath(a.getPath());
			ab.setPrix(a.getPrix());
			ab.setTotal(a.getTotal());
			panier catupdate=rep.save(ab);
	       return ResponseEntity.ok(catupdate);
        
    }
	   @DeleteMapping("/panier/{id}")
	   public void delete(@PathVariable Long id) {
	       ser.delete(id);
	   }
}
