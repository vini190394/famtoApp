package com.example.famto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "test")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deliveryId;
	

	public Test(long deliveryId, String deliveryName) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryName = deliveryName;
	}



	public long getDeliveryId() {
		return deliveryId;
	}



	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}



	public String getDeliveryName() {
		return deliveryName;
	}



	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}



	@Column(name = "delivery_type")
	private String deliveryName;
	
	

	public Test () {
		
	}

}


