package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.famto.entity.DeliveryCategory;


@Repository

public interface DeliveryCategoryRepository extends JpaRepository<DeliveryCategory, Long> {
	

}