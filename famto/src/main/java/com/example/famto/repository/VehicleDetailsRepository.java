package com.example.famto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.VehicleDetails;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Long> {
    List<VehicleDetails> findByDeliveryPersonDeliveryUserId(long deliveryUserId);
}
