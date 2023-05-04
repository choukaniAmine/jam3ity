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

import com.example.demo.model.joueurs;

import com.example.demo.repositor.joueursRepositor;

import com.example.demo.service.joueursService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class joueursController {
	@Autowired
    private joueursService ser;
 @Autowired
 private joueursRepositor rep;
 @GetMapping("/joueurs")
    public List<joueurs> list() {
	
             return ser.getAll();
   }
 	 
 @GetMapping("/joueurs/{id}")
 public ResponseEntity<joueurs> post(@PathVariable String id){
 			 			

Optional<joueurs> cat=ser.findByEmail(id);
return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }
 @PostMapping("/joueurs")
    public long save(@RequestBody joueurs cat) {
	 
        return ser.save(cat);
    }
 @PutMapping("/joueurs/{id}")      
	   public ResponseEntity<joueurs> update(@PathVariable long id, @RequestBody joueurs a) {
		   joueurs ab = rep.findById(id)
	    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
			ab.setId(a.getId());
			ab.setEmail(a.getEmail());
			ab.setNom(a.getNom());
			ab.setPrenom(a.getPrenom());
			ab.setTel(a.getTel());
			ab.setDateDeNaissance(a.getDateDeNaissance());
			ab.setPoste(a.getPoste());
			joueurs catupdate=rep.save(ab);
	       return ResponseEntity.ok(catupdate);
        
    }
	   @DeleteMapping("/joueurs/{id}")
	   public void delete(@PathVariable String id) {
	       ser.delete(id);
	   }
}
