package com.example.famto.contoller;

import java.io.IOException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.famto.entity.RestaurantData;

import com.example.famto.exception.ResourceNotFoundException;

import com.example.famto.repository.RestaurantRepo;


@RestController
@RequestMapping("/api/restaurants")


public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo;

	// get all restaurants
	@GetMapping
	public List<RestaurantData> getAllRestaurants() {
		return this.restaurantRepo.findAll();
		
	}

	// get restaurants by id
	@GetMapping("/{restaurantId}")
	public RestaurantData getRestaurantById(@PathVariable (value = "restaurantId") int restaurantId) {
		return this.restaurantRepo.findById(restaurantId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with restaurantId"));
	}

	// create restaurant
	@PostMapping
	
	public RestaurantData createRestaurant(@RequestBody RestaurantData restaurantData) {
		return this.restaurantRepo.save(restaurantData);
	
	}
	
	// update restaurant data
	@PutMapping("/{restaurantId}")
	public RestaurantData updateRestaurant(@RequestBody RestaurantData restaurantData, @PathVariable ("restaurantId") int restaurantId,HttpServletRequest request) {
		RestaurantData existingRestaurant = this.restaurantRepo.findById(restaurantId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with restaurantId"));
		
		if(restaurantData.getRestaurantName() != null) {
			existingRestaurant.setRestaurantName(restaurantData.getRestaurantName());
		}
		if(restaurantData.getAddress() != null) {
			existingRestaurant.setAddress(restaurantData.getAddress());
		}
		if(restaurantData.getPhone() != null) {
			existingRestaurant.setPhone(restaurantData.getPhone());
		}
		if(restaurantData.getEmail() != null) {
			existingRestaurant.setEmail(restaurantData.getEmail());
		}
		if(restaurantData.getCity() != null) {
			existingRestaurant.setCity(restaurantData.getCity());
		}
		if(restaurantData.getDisplayAddress() != null) {
			existingRestaurant.setDisplayAddress(restaurantData.getDisplayAddress());
		}
		if(restaurantData.getContactName() != null) {
			existingRestaurant.setContactName(restaurantData.getContactName());
		}
		if(restaurantData.getDescription() != null) {
			existingRestaurant.setDescription(restaurantData.getDescription());
		}
		if(restaurantData.getSlug() != null) {
			existingRestaurant.setSlug(restaurantData.getSlug());
		}
		if(restaurantData.getLogoUrl() != null) {
			existingRestaurant.setLogoUrl(restaurantData.getLogoUrl());
		}
		
		if(restaurantData.getBannerUrl() != null) {
			existingRestaurant.setBannerUrl(restaurantData.getBannerUrl());
		}
		if(restaurantData.getBgColour() != null) {
			existingRestaurant.setBgColour(restaurantData.getBgColour());
		}
		if(restaurantData.getRatingBarColor() != null) {
			existingRestaurant.setRatingBarColor(restaurantData.getRatingBarColor());
		}
		if(restaurantData.getLocation() != null) {
			existingRestaurant.setLocation(restaurantData.getLocation());
		}		
		if(restaurantData.getServingArea() != null) {
			existingRestaurant.setServingArea(restaurantData.getServingArea());
		}
		if(restaurantData.getCommissionType() != null) {
			existingRestaurant.setCommissionType(restaurantData.getCommissionType());
		}		
		
//		if(restaurantData.getRating() != null) {
//			existingRestaurant.setRating(restaurantData.getRating());
//		}		
		if(restaurantData.getServiceStatus() != null) {
			existingRestaurant.setServiceStatus(restaurantData.getServiceStatus());
		}
		if(restaurantData.getSponsorship() != null) {
			existingRestaurant.setSponsorship(restaurantData.getSponsorship());
		}		
		if(restaurantData.getCommissionValue() != null) {
			existingRestaurant.setCommissionValue(restaurantData.getCommissionValue());
		}
		if(restaurantData.getLatitude() != null) {
			existingRestaurant.setLatitude(restaurantData.getLatitude());
		}		
		if(restaurantData.getLongitude() != null) {
			existingRestaurant.setLongitude(restaurantData.getLongitude());
		}
		if(restaurantData.getTags() != null) {
			existingRestaurant.setTags(restaurantData.getTags());
		}
		if(restaurantData.getDate() != null) {
		existingRestaurant.setDate(restaurantData.getDate()); // Update date
		}
		if(restaurantData.getStartTime() != null) {
        existingRestaurant.setStartTime(restaurantData.getStartTime()); // Update start time
		}
		if(restaurantData.getEndTime() != null) {
        existingRestaurant.setEndTime(restaurantData.getEndTime()); // Update end time
		}
		// Check if registration approval parameter is provided
	    Boolean registrationApproved = Boolean.valueOf(request.getParameter("registrationApproved"));
	    if (registrationApproved != null) {
	        existingRestaurant.setRegistrationApproved(registrationApproved);
	    }

	    // Check if status parameter is provided
	    String status = request.getParameter("status");
	    if (status != null) {
	        existingRestaurant.setStatus(status);
	    }
	    if (restaurantData.getBusinessCategory() != null) {
            existingRestaurant.setBusinessCategory(restaurantData.getBusinessCategory());
        }
	    if (restaurantData.getTime() != null) {
            existingRestaurant.setTime(restaurantData.getTime());
        }
	    if (restaurantData.getNoServing() != null) {
            existingRestaurant.setNoServing(restaurantData.getNoServing());
        }
	    if (restaurantData.getServingRadius() != null) {
            existingRestaurant.setServingRadius(restaurantData.getServingRadius());
        }
	    if (restaurantData.getName() != null) {
            existingRestaurant.setName(restaurantData.getName());
        }
	    if (restaurantData.getDay() != null) {
	        existingRestaurant.setDay(restaurantData.getDay());
	    }
	    if (restaurantData.getAmount() != null) {
	        existingRestaurant.setAmount(restaurantData.getAmount());
	    }
	    if (restaurantData.getDuration() != null) {
	        existingRestaurant.setDuration(restaurantData.getDuration());
	    }
	    if (restaurantData.getTaxId() != null) {
	        existingRestaurant.setTaxId(restaurantData.getTaxId());
	    }
	    if (restaurantData.getRenewal() != null) {
	        existingRestaurant.setRenewal(restaurantData.getRenewal());
	    }
	    if (restaurantData.getReasonForBlocking() != null) {
	        existingRestaurant.setReasonForBlocking(restaurantData.getReasonForBlocking());
	    }
	    
	 // Assuming restaurantData is an instance of RestaurantData
	    if (restaurantData.hasRating() && restaurantData.getRating() != 0.0) {
	        // Perform actions based on the rating
	    }
	    if (restaurantData.getPanCardNumber() != null) {
	        existingRestaurant.setPanCardNumber(restaurantData.getPanCardNumber());
	    }
	    if (restaurantData.getPanCardPhoto() != null) {
	        existingRestaurant.setPanCardPhoto(restaurantData.getPanCardPhoto());
	    }
	    if (restaurantData.getGstinNumber() != null) {
	        existingRestaurant.setGstinNumber(restaurantData.getGstinNumber());
	    }
	    if (restaurantData.getGstinPhoto() != null) {
	        existingRestaurant.setGstinPhoto(restaurantData.getGstinPhoto());
	    }
	    if (restaurantData.getFssaiNumber() != null) {
	        existingRestaurant.setFssaiNumber(restaurantData.getFssaiNumber());
	    }
	    if (restaurantData.getFssaiPhoto() != null) {
	        existingRestaurant.setFssaiPhoto(restaurantData.getFssaiPhoto());
	    }
	    if (restaurantData.getAadhaarNumber() != null) {
	        existingRestaurant.setAadhaarNumber(restaurantData.getAadhaarNumber());
	    }
	    if (restaurantData.getAadhaarPhoto() != null) {
	        existingRestaurant.setAadhaarPhoto(restaurantData.getAadhaarPhoto());
	    }

	    
	    existingRestaurant.setOpenAllDay(restaurantData.isOpenAllDay());
	    existingRestaurant.setClosedAllDay(restaurantData.isClosedAllDay());
	    existingRestaurant.setSpecificTime(restaurantData.isSpecificTime());
	    existingRestaurant.setImageUrl(restaurantData.getImageUrl());

		 return this.restaurantRepo.save(existingRestaurant);
	}
	
	
	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<RestaurantData> deleteRestaurant(@PathVariable ("restaurantId") int restaurantId){
		RestaurantData existingRestaurant = this.restaurantRepo.findById(restaurantId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + restaurantId));
		 this.restaurantRepo.delete(existingRestaurant);
		 return ResponseEntity.ok().build();
	} 
	
	// Get restaurant location by ID
	@GetMapping("/{restaurantId}/location")
	public ResponseEntity<Map<String, Double>> getRestaurantLocation(@PathVariable("restaurantId") int restaurantId) {
	    RestaurantData restaurant = restaurantRepo.findById(restaurantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

	    // Extract latitude and longitude
	    Double latitude = restaurant.getLatitude();
	    Double longitude = restaurant.getLongitude();

	    // Create a map to hold the location data
	    Map<String, Double> locationData = new HashMap<>();
	    locationData.put("latitude", latitude);
	    locationData.put("longitude", longitude);

	    return ResponseEntity.ok().body(locationData);
	}
	
	// Update restaurant data with location
	@PutMapping("/{restaurantId}/location")
	public ResponseEntity<RestaurantData> updateRestaurantLocation(@PathVariable("restaurantId") int restaurantId, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
	    RestaurantData restaurant = restaurantRepo.findById(restaurantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

	    // Update the latitude and longitude
	    restaurant.setLatitude(latitude);
	    restaurant.setLongitude(longitude);

	    // Save the updated restaurant data
	    RestaurantData updatedRestaurant = restaurantRepo.save(restaurant);

	    return ResponseEntity.ok().body(updatedRestaurant);
	}
	
	
	// Get restaurant data with document information
    @GetMapping("/{restaurantId}/documents")
    public ResponseEntity<RestaurantData> getRestaurantDocuments(@PathVariable("restaurantId") int restaurantId) {
        // Retrieve restaurant data
        RestaurantData restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

        return ResponseEntity.ok().body(restaurant);
    }
	
    @PutMapping("/{restaurantId}/documents")
    public ResponseEntity<RestaurantData> updateRestaurantDocuments(
            @PathVariable("restaurantId") int restaurantId,
            @RequestBody Map<String, String> documentData,
            @RequestPart("panCardPhoto") MultipartFile panCardPhoto,
            @RequestPart("gstinPhoto") MultipartFile gstinPhoto,
            @RequestPart("fssaiPhoto") MultipartFile fssaiPhoto,
            @RequestPart("aadhaarPhoto") MultipartFile aadhaarPhoto) {

        try {
            // Retrieve restaurant data
            RestaurantData restaurant = restaurantRepo.findById(restaurantId)
                    .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

            // Update document information
            if (documentData.containsKey("panCardNumber")) {
                restaurant.setPanCardNumber(documentData.get("panCardNumber"));
            }
            if (documentData.containsKey("gstinNumber")) {
                restaurant.setGstinNumber(documentData.get("gstinNumber"));
            }
            if (documentData.containsKey("fssaiNumber")) {
                restaurant.setFssaiNumber(documentData.get("fssaiNumber"));
            }
            if (documentData.containsKey("aadhaarNumber")) {
                restaurant.setAadhaarNumber(documentData.get("aadhaarNumber"));
            }

            // Update photos
            restaurant.setPanCardPhoto(panCardPhoto.getBytes());
            restaurant.setGstinPhoto(gstinPhoto.getBytes());
            restaurant.setFssaiPhoto(fssaiPhoto.getBytes());
            restaurant.setAadhaarPhoto(aadhaarPhoto.getBytes());

            // Save the updated restaurant data
            RestaurantData updatedRestaurant = restaurantRepo.save(restaurant);

            return ResponseEntity.ok().body(updatedRestaurant);
        } catch (IOException e) {
            // Handle IO exception (e.g., failed to read file)
            e.printStackTrace(); // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Return internal server error
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace(); // Log the error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return bad request status
        }
    }

    
    
 // Update food type and order type
    @PutMapping("/{restaurantId}/types")
    public ResponseEntity<RestaurantData> updateFoodAndOrderTypes(
            @PathVariable("restaurantId") int restaurantId,
            @RequestParam("foodTypeVeg") boolean foodTypeVeg,
            @RequestParam("foodTypeNonVeg") boolean foodTypeNonVeg,
            @RequestParam("foodTypeBoth") boolean foodTypeBoth,
            @RequestParam("orderTypeOnDemand") boolean orderTypeOnDemand,
            @RequestParam("orderTypeScheduled") boolean orderTypeScheduled,
            @RequestParam("orderTypeBoth") boolean orderTypeBoth) {

        // Retrieve restaurant data
        RestaurantData restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

        // Update food type
        restaurant.setFoodTypeVeg(foodTypeVeg);
        restaurant.setFoodTypeNonVeg(foodTypeNonVeg);
        restaurant.setFoodTypeBoth(foodTypeBoth);

        // Update order type
        restaurant.setOrderTypeOnDemand(orderTypeOnDemand);
        restaurant.setOrderTypeScheduled(orderTypeScheduled);
        restaurant.setOrderTypeBoth(orderTypeBoth);

        // Save the updated restaurant data
        RestaurantData updatedRestaurant = restaurantRepo.save(restaurant);

        return ResponseEntity.ok().body(updatedRestaurant);
    }

    // Get food and order types by ID
    @GetMapping("/{restaurantId}/types")
    public ResponseEntity<Map<String, Boolean>> getFoodAndOrderTypes(@PathVariable("restaurantId") int restaurantId) {
        // Retrieve restaurant data
        RestaurantData restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));

        // Extract food and order types
        boolean foodTypeVeg = restaurant.isFoodTypeVeg();
        boolean foodTypeNonVeg = restaurant.isFoodTypeNonVeg();
        boolean foodTypeBoth = restaurant.isFoodTypeBoth();
        boolean orderTypeOnDemand = restaurant.isOrderTypeOnDemand();
        boolean orderTypeScheduled = restaurant.isOrderTypeScheduled();
        boolean orderTypeBoth = restaurant.isOrderTypeBoth();

        // Create a map to hold the types data
        Map<String, Boolean> typesData = Map.of(
                "foodTypeVeg", foodTypeVeg,
                "foodTypeNonVeg", foodTypeNonVeg,
                "foodTypeBoth", foodTypeBoth,
                "orderTypeOnDemand", orderTypeOnDemand,
                "orderTypeScheduled", orderTypeScheduled,
                "orderTypeBoth", orderTypeBoth
        );

        return ResponseEntity.ok().body(typesData);
    }
    
	
	@GetMapping("/search")
    public List<RestaurantData> searchRestaurants(@RequestParam String query) {
        List<RestaurantData> restaurants = restaurantRepo.searchRestaurants(query);
        return restaurants;
    }

}
