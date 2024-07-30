package com.example.famto.contoller;

import com.example.famto.entity.CustomerData;
import com.example.famto.entity.WalletData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.CustomerRepo;
import com.example.famto.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private CustomerRepo customerRepo;

    // Add money to the wallet
    @PostMapping("/{customerId}/wallet/add")
    public ResponseEntity<WalletData> addMoneyToWallet(@PathVariable("customerId") int customerId,
                                                       @RequestParam Double amount) {
        CustomerData customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        // Create a new wallet transaction
        WalletData transaction = new WalletData();
        transaction.setCustomerId(customerId);
        transaction.setTransactionAmount(amount);
        transaction.setTransactionType("Credit"); // Or any other appropriate value
        transaction.setTransactionStatus("Success"); // Or "Pending", etc. depending on your requirements
        // Set transaction date
        transaction.setTransactionDate(new Date());
        // Set transaction time
        transaction.setTransactionTime(new Time(System.currentTimeMillis())); // Set current time
        // Save the transaction to the database
        WalletData savedTransaction = walletRepo.save(transaction);

        // Update the customer's wallet balance
        Double updatedBalance = customer.getWalletBalance() + amount;
        customer.setWalletBalance(updatedBalance);
        customerRepo.save(customer);

        return ResponseEntity.ok(savedTransaction);
    }

    // Get transaction details
    @GetMapping("/{customerId}/wallet/transactions")
    public List<WalletData> getWalletTransactions(@PathVariable("customerId") int customerId) {
        return walletRepo.findByCustomerId(customerId);
    }
}
