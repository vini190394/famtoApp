package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.Login;

@Repository

public interface LoginRepository extends JpaRepository<Login, Long> {
	

}
