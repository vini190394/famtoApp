	package com.example.famto.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.example.famto.entity.CategoryData;


	@Repository

	public interface CategoryRepo extends JpaRepository<CategoryData, Integer>{
		
		@Query("SELECT u FROM CategoryData u WHERE u.restaurantId = ?1")
		List<CategoryData> findRestaurantCategory(int restaurantId);
		
	}
