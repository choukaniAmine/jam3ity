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

import com.example.demo.model.admin;
import com.example.demo.repositor.adminRepositor;
import com.example.demo.service.adminService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class adminController {
	 @Autowired
	    private adminService ser;
	 @Autowired
	 private adminRepositor rep;
	 @GetMapping("/admin")
	    public List<admin> list() {
		
	             return ser.getAll();
	   }
	 	 
	 @GetMapping("/admin/{id}")
	 public ResponseEntity<admin> post(@PathVariable String id){
	 			Optional<admin> cat=ser.findByEmail(id);
	 			return cat.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());

	    }
	 @PostMapping("/admin")
	    public long save(@RequestBody admin cat) {
		 
	        return ser.save(cat);
	    }
	 @PutMapping("/admin/{id}")      
		   public ResponseEntity<admin> update(@PathVariable long id, @RequestBody admin a) {
		       admin ab = rep.findById(id)
		    		   .orElseThrow(() -> new exception.resourceNotFoundException("categorie not exist"));
				ab.setId(a.getId());
				ab.setEmail(a.getEmail());
				ab.setPwd(ab.getPwd());
		    admin catupdate=rep.save(ab);
		       return ResponseEntity.ok(catupdate);
	        
	    }
		   @DeleteMapping("/admin/{id}")
		   public void delete(@PathVariable String id) {
		       ser.delete(id);
		   }
}
