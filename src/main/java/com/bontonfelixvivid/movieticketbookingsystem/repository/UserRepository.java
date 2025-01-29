package com.bontonfelixvivid.movieticketbookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bontonfelixvivid.movieticketbookingsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByUserEmailId(String userEmailId);
	
}
