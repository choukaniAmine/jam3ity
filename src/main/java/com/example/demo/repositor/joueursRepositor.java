package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.joueurs;

public interface  joueursRepositor	extends JpaRepository<joueurs,Long> {
	Optional<joueurs> findByEmail(String code);
}
