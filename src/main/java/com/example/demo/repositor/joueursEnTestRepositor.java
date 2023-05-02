package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.joueursEnTest;

public interface  joueursEnTestRepositor extends JpaRepository<joueursEnTest,Long> {
	Optional<joueursEnTest> findByEmail(String code);
}
