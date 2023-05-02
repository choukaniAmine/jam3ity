package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.admin;

public interface adminRepositor extends JpaRepository<admin,Long> {
	Optional<admin> findByEmail(String code);
}
