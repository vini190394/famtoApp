package com.example.famto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "delivery_category")
public class DeliveryCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deliveryId;
	

	@Column(name = "delivery_type")
	private String deliveryName;
	
	@Column(name = "image_url")
	private String image;
	
	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DeliveryCategory () {
		
	}

	public DeliveryCategory(String deliveryName, String image) {
		super();
		this.deliveryName = deliveryName;
		this.image = image;
	}
}


