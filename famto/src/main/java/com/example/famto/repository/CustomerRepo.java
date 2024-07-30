package com.example.famto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.CustomerData;
import com.example.famto.entity.RestaurantData;




@Repository

public interface CustomerRepo extends JpaRepository<CustomerData, Integer>{

	 @Query("SELECT p FROM CustomerData p WHERE " +
			 
			 "p.name LIKE CONCAT('%',:query, '%')" )
	 
	    List<CustomerData> searchCustomers(String query);
}
