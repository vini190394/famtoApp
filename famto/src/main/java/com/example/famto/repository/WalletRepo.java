package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.WalletData;

import java.util.List;

@Repository
public interface WalletRepo extends JpaRepository<WalletData, Long> {

    // Add a method to find wallet transactions by customer ID
    List<WalletData> findByCustomerId(int customerId);
}
