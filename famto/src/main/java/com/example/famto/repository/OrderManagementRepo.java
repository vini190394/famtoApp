package com.example.famto.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.OrderManagement;

@Repository
public interface OrderManagementRepo extends JpaRepository<OrderManagement, Integer> {
    
//    @Query("SELECT o FROM OrderManagement o WHERE o.customerData.customerId = :customerId")
//    List<OrderManagement> findByCustomerId(int customerId);
    
    @Query("SELECT u FROM OrderManagement u WHERE u.customerId = ?1")
    List<OrderManagement> findByCustomerId(int customerId);
}
