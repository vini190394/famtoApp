package com.example.famto.contoller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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

import com.example.famto.entity.ApprovalStatus;
import com.example.famto.entity.DeliveryPersonRegistration;
import com.example.famto.entity.VehicleDetails;
import com.example.famto.repository.DeliveryPersonRegistrationRepository;
import com.example.famto.repository.VehicleDetailsRepository;

@RestController
@RequestMapping("/api/delivery-person-registration")

public class DeliveryPersonRegistrationController {
	
	@Autowired
	private DeliveryPersonRegistrationRepository deliveryPersonRegistrationRepository;
	
	@Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;

	// get all registered delivery person data
	@GetMapping
	public List<DeliveryPersonRegistration> getAllDeliveryLogins() {
		return this.deliveryPersonRegistrationRepository.findAll();
		
	}

	// get delivery person by id
	@GetMapping("/{deliveryUserId}")
	public DeliveryPersonRegistration getDeliveryPersonRegById(@PathVariable (value = "deliveryUserId") long deliveryUserId) {
		return this.deliveryPersonRegistrationRepository.findById(deliveryUserId).orElseThrow();
	}
	
	// get delivery person details by phone number
	@GetMapping("/phoneNumber/{phoneNumber}")
	public DeliveryPersonRegistration getDeliveryPersonRegByPhone(@PathVariable (value = "phoneNumber") String phoneNumber) {
				return this.deliveryPersonRegistrationRepository.getDeliveryPersonDetails(phoneNumber).get(0);
	}

	// create delivery person through registration
	@PostMapping
	public DeliveryPersonRegistration createDeliveryPersonReg(@RequestBody DeliveryPersonRegistration deliveryPersonReg) {	
		return this.deliveryPersonRegistrationRepository.save(deliveryPersonReg);
		}
	
	// update login
	@PutMapping("/{deliveryUserId}")
	public DeliveryPersonRegistration updateDeliveryLogin(@RequestBody DeliveryPersonRegistration deliveryLogin, @PathVariable ("deliveryUserId") long deliveryUserId) {
		DeliveryPersonRegistration existingRegistrationDetails = this.deliveryPersonRegistrationRepository.findById(deliveryUserId)
			.orElseThrow();
		if (deliveryLogin.getPhoneNumber() != null) {
			existingRegistrationDetails.setPhoneNumber(deliveryLogin.getPhoneNumber());
		}

		if (deliveryLogin.getAddress() != null) {
			existingRegistrationDetails.setAddress(deliveryLogin.getAddress());
		}
		
		if (deliveryLogin.getAadhaar() != null) {
			existingRegistrationDetails.setAadhaar(deliveryLogin.getAadhaar());
		}
		if (deliveryLogin.getPan() != null) {
			existingRegistrationDetails.setPan(deliveryLogin.getPan());
		}
		if (deliveryLogin.getDrivingLicense() != null) {
			existingRegistrationDetails.setDrivingLicense(deliveryLogin.getDrivingLicense());
		}
		if (deliveryLogin.getEmergencyContact() != null) {
			existingRegistrationDetails.setEmergencyContact(deliveryLogin.getEmergencyContact());
		}
		if (deliveryLogin.getVehicleRegistration() != null) {
			existingRegistrationDetails.setVehicleRegistration(deliveryLogin.getVehicleRegistration());
		}
		if (deliveryLogin.getPhoto() != null) {
			existingRegistrationDetails.setPhoto(deliveryLogin.getPhoto());
		}
		if (deliveryLogin.getStatus() != null) {
			existingRegistrationDetails.setStatus(deliveryLogin.getStatus());
		}
		if (deliveryLogin.getAvailability() != null) {
			existingRegistrationDetails.setAvailability(deliveryLogin.getAvailability()); 
			}
		if (deliveryLogin.getColor() != null) {
			existingRegistrationDetails.setColor(deliveryLogin.getColor()); 
			}		
	
		if (deliveryLogin.getEmail() != null) {
					existingRegistrationDetails.setEmail(deliveryLogin.getEmail()); 
				}		
		if (deliveryLogin.getFirstName() != null) {
					existingRegistrationDetails.setFirstName(deliveryLogin.getFirstName()); 
				}		
		if (deliveryLogin.getGeofence() != null) {
					existingRegistrationDetails.setGeofence(deliveryLogin.getGeofence()); 
				}
		if (deliveryLogin.getGeometry() != null) {
			existingRegistrationDetails.setGeometry(deliveryLogin.getGeometry()); 
		}
		if (deliveryLogin.getLastName() != null) {
			existingRegistrationDetails.setLastName(deliveryLogin.getLastName()); 
		}
		if (deliveryLogin.getLicensePlate() != null) {
			existingRegistrationDetails.setLicensePlate(deliveryLogin.getLicensePlate()); 
		}
		if (deliveryLogin.getPassword() != null) {
			existingRegistrationDetails.setPassword(deliveryLogin.getPassword()); 
		}
		if (deliveryLogin.getRole() != null) {
			existingRegistrationDetails.setRole(deliveryLogin.getRole()); 
		}
		if (deliveryLogin.getTeam() != null) {
			existingRegistrationDetails.setTeam(deliveryLogin.getTeam()); 
		}
		if (deliveryLogin.getTransportDescription() != null) {
			existingRegistrationDetails.setTransportDescription(deliveryLogin.getTransportDescription()); 
		}
		if (deliveryLogin.getTransportType() != null) {
			existingRegistrationDetails.setTransportType(deliveryLogin.getTransportType()); 
		}		
		if (deliveryLogin.getType() != null) {
			existingRegistrationDetails.setType(deliveryLogin.getType()); 
		}
		if (deliveryLogin.getUserName() != null) {
			existingRegistrationDetails.setUserName(deliveryLogin.getUserName()); 
		}
		if (deliveryLogin.getLatitude() != null) {
			existingRegistrationDetails.setLatitude(deliveryLogin.getLatitude()); 
		}
		if (deliveryLogin.getLongitude() != null) {
			existingRegistrationDetails.setLongitude(deliveryLogin.getLongitude()); 
		}
		if (deliveryLogin.getApprovalStatus() != null) {
			existingRegistrationDetails.setApprovalStatus(deliveryLogin.getApprovalStatus()); 
		}
//		if (deliveryLogin.getTags() != null) {
//			existingRegistrationDetails.setTags(deliveryLogin.getTags()); 
//		}
		
		// Update image URLs
	    existingRegistrationDetails.setAadharFrontPhotoUrl(deliveryLogin.getAadharFrontPhotoUrl());
	    existingRegistrationDetails.setAadharBackPhotoUrl(deliveryLogin.getAadharBackPhotoUrl());
	    existingRegistrationDetails.setLicenseFrontPhotoUrl(deliveryLogin.getLicenseFrontPhotoUrl());
	    existingRegistrationDetails.setLicenseBackPhotoUrl(deliveryLogin.getLicenseBackPhotoUrl());

	 // Update bank details if included in the request body
	    existingRegistrationDetails.setPaymentEmail(deliveryLogin.getPaymentEmail());
	    existingRegistrationDetails.setBankAccountHolderName(deliveryLogin.getBankAccountHolderName());
	    existingRegistrationDetails.setBankAccountNumber(deliveryLogin.getBankAccountNumber());
	    existingRegistrationDetails.setBankName(deliveryLogin.getBankName());
	    existingRegistrationDetails.setBranch(deliveryLogin.getBranch());
	    existingRegistrationDetails.setIfscCode(deliveryLogin.getIfscCode());
	    existingRegistrationDetails.setUpiId(deliveryLogin.getUpiId());
	    
		 return this.deliveryPersonRegistrationRepository.save(existingRegistrationDetails);
	}
	
	// delete delivery person by id
	@DeleteMapping("/{deliveryUserId}")
	public ResponseEntity<DeliveryPersonRegistration> deleteDeliveryLogin(@PathVariable ("deliveryUserId") long deliveryUserId){
		DeliveryPersonRegistration existingRegistration = this.deliveryPersonRegistrationRepository.findById(deliveryUserId)
					.orElseThrow();
		 this.deliveryPersonRegistrationRepository.delete(existingRegistration);
		 return ResponseEntity.ok().build();
	}
	
	@GetMapping("/agentExists")
    public Boolean agentExists(String status, String phoneNumber) {
		DeliveryPersonRegistration agentData = deliveryPersonRegistrationRepository.findUserByStatusAndPhoneNumber(status, phoneNumber);
        if(agentData != null) {
        	return true;	
        } else {
        	return false;
        }
		
    }
	
	// Add vehicle details for a delivery person
    @PostMapping("/{deliveryUserId}/vehicles")
    public ResponseEntity<VehicleDetails> addVehicleDetailsForDeliveryPerson(
            @PathVariable("deliveryUserId") long deliveryUserId,
            @RequestBody VehicleDetails vehicleDetails) {
        DeliveryPersonRegistration deliveryPerson = deliveryPersonRegistrationRepository.findById(deliveryUserId)
                .orElseThrow(() -> new EntityNotFoundException("Delivery person not found"));
        vehicleDetails.setDeliveryPerson(deliveryPerson);
        VehicleDetails savedVehicleDetails = vehicleDetailsRepository.save(vehicleDetails);
        return ResponseEntity.ok().body(savedVehicleDetails);
    }

    // Get all vehicles of a delivery person
    @GetMapping("/{deliveryUserId}/vehicles")
    public List<VehicleDetails> getAllVehiclesForDeliveryPerson(@PathVariable("deliveryUserId") long deliveryUserId) {
        return vehicleDetailsRepository.findByDeliveryPersonDeliveryUserId(deliveryUserId);
    }

    // Update vehicle details
    @PutMapping("/{deliveryUserId}/vehicles/{vehicleId}")
    public ResponseEntity<VehicleDetails> updateVehicleDetails(
            @PathVariable("deliveryUserId") long deliveryUserId,
            @PathVariable("vehicleId") long vehicleId,
            @RequestBody VehicleDetails vehicleDetails) {
        VehicleDetails existingVehicleDetails = vehicleDetailsRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle details not found"));
        
        // Update vehicle details
        existingVehicleDetails.setVehicleModel(vehicleDetails.getVehicleModel());
        existingVehicleDetails.setVehicleType(vehicleDetails.getVehicleType());
        existingVehicleDetails.setLicensePlate(vehicleDetails.getLicensePlate());
        existingVehicleDetails.setRcFrontPhotoUrl(vehicleDetails.getRcFrontPhotoUrl());
        existingVehicleDetails.setRcBackPhotoUrl(vehicleDetails.getRcBackPhotoUrl());
        
        // Save the updated vehicle details
        VehicleDetails updatedVehicleDetails = vehicleDetailsRepository.save(existingVehicleDetails);
        return ResponseEntity.ok().body(updatedVehicleDetails);
    }
    
    // Delete vehicle details
    @DeleteMapping("/{deliveryUserId}/vehicles/{vehicleId}")
    public ResponseEntity<VehicleDetails> deleteVehicleDetails(
            @PathVariable("deliveryUserId") long deliveryUserId,
            @PathVariable("vehicleId") long vehicleId) {
        VehicleDetails vehicleDetails = vehicleDetailsRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle details not found"));
        vehicleDetailsRepository.delete(vehicleDetails);
        return ResponseEntity.ok().build();
    }
    
    
    
    
    
 // Get all delivery persons by approval status
    @GetMapping("/approval-status/{status}")
    public List<DeliveryPersonRegistration> getDeliveryPersonsByApprovalStatus(@PathVariable("status") ApprovalStatus status) {
        return deliveryPersonRegistrationRepository.findByApprovalStatus(status);
    }
    
    @PutMapping("/{deliveryUserId}/approve")
    public ResponseEntity<DeliveryPersonRegistration> approveDeliveryAgent(@PathVariable("deliveryUserId") long deliveryUserId) {
        DeliveryPersonRegistration agent = deliveryPersonRegistrationRepository.findById(deliveryUserId)
                .orElseThrow(() -> new EntityNotFoundException("Delivery agent not found"));
        agent.setApprovalStatus(ApprovalStatus.APPROVED);
        deliveryPersonRegistrationRepository.save(agent);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{deliveryUserId}/reject")
    public ResponseEntity<DeliveryPersonRegistration> rejectDeliveryAgent(@PathVariable("deliveryUserId") long deliveryUserId) {
        DeliveryPersonRegistration agent = deliveryPersonRegistrationRepository.findById(deliveryUserId)
                .orElseThrow(() -> new EntityNotFoundException("Delivery agent not found"));
        agent.setApprovalStatus(ApprovalStatus.REJECTED);
        deliveryPersonRegistrationRepository.save(agent);
        return ResponseEntity.ok().build();
    }


}

