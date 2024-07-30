package com.example.famto.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_data")
public class WalletData implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "transaction_amount")
    private Double transactionAmount;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "transaction_status")
    private String transactionStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date transactionDate;
    
    @Column(name = "transaction_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTime;

	/**
	 * 
	 */
	public WalletData() {
		super();
	}

	/**
	 * @param id
	 * @param customerId
	 * @param transactionAmount
	 * @param transactionType
	 * @param transactionId
	 * @param transactionStatus
	 * @param transactionDate
	 * @param transactionTime
	 */
	public WalletData(Long id, int customerId, Double transactionAmount, String transactionType, String transactionId,
			String transactionStatus, Date transactionDate, Date transactionTime) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.transactionStatus = transactionStatus;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
	}
	
	   // Getters and setters...

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
	
 
    
}

