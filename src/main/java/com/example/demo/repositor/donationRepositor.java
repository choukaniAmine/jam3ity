package com.example.demo.repositor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.donation;

public interface donationRepositor 	extends JpaRepository<donation,Long> {

}
