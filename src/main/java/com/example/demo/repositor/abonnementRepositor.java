package com.example.demo.repositor;



import com.example.demo.model.abonnement;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface abonnementRepositor extends JpaRepository<abonnement,Long> {
	Optional<abonnement> findByCode(String code);
}
