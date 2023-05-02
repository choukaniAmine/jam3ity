package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.entraineur;

public interface  entraineurRepositor extends JpaRepository<entraineur,Long> {
	Optional<entraineur> findByEmail(String code);
}
