package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.joueursEnDemande;

public interface joueursEnDemandeRepositor	extends JpaRepository<joueursEnDemande,Long> {
	Optional<joueursEnDemande> findByEmail(String code);
}
