package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.famto.entity.Test;


@Repository

public interface TestRepository extends JpaRepository<Test, Long> {
	

}