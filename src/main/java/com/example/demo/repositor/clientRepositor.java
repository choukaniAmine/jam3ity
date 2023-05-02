package com.example.demo.repositor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.client;

public interface  clientRepositor extends JpaRepository<client,Long> {
	Optional<client> findByEmail(String code);
}
