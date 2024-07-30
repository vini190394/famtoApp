package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.CustomerData;
import com.example.famto.entity.RestaurantData;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository

public interface RestaurantRepo extends JpaRepository<RestaurantData, Integer>{
	 @Query("SELECT p FROM RestaurantData p WHERE " +
	 
			 "p.restaurantName LIKE CONCAT('%',:query, '%')" )
	 
	    List<RestaurantData> searchRestaurants(String query);

}
