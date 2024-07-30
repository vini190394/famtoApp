package com.example.famto.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.famto.entity.CategoryData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.CategoryRepo;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryRepo categoryRepo;

	// get all restaurants
	@GetMapping
	public List<CategoryData> getAllCategory() {
		return this.categoryRepo.findAll();
		
	}

	// get restaurants by id
	@GetMapping("/{categoryId}")
	public CategoryData getCategoryById(@PathVariable (value = "categoryId") int categoryId) {
		return this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with categoryId"));
	}

	// create restaurant
	@PostMapping
	
	public CategoryData createCategory(@RequestBody CategoryData categoryData) {
		return this.categoryRepo.save(categoryData);
	
	}
	
	// update restaurant data
	@PutMapping("/{categoryId}")
	public CategoryData updateCategory(@RequestBody CategoryData categoryData, @PathVariable ("categoryId") int categoryId) {
		CategoryData existingCategory = this.categoryRepo.findById(categoryId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with categoryId"));
		
		if(categoryData.getRestaurantId() != null) {
			existingCategory.setRestaurantId(categoryData.getRestaurantId());
		}
		if(categoryData.getRestaurantName() != null) {
			existingCategory.setRestaurantName(categoryData.getRestaurantName());
		}
		if(categoryData.getCategory() != null) {
			existingCategory.setCategory(categoryData.getCategory());
		}
		if(categoryData.getDescription() != null) {
			existingCategory.setDescription(categoryData.getDescription());
		}
		 return this.categoryRepo.save(existingCategory);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<CategoryData> deleteRestaurant(@PathVariable ("categoryId") int categoryId){
		CategoryData existingCategory = this.categoryRepo.findById(categoryId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + categoryId));
		 this.categoryRepo.delete(existingCategory);
		 return ResponseEntity.ok().build();
	} 
	
	@GetMapping("/restaurant-categories")
    public List<CategoryData> searchRestaurantCategories(int restaurantId) {
        List<CategoryData> restaurantCategories = categoryRepo.findRestaurantCategory(restaurantId);
        return restaurantCategories;
    }


}
