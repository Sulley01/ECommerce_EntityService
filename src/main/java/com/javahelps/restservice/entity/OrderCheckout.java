package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderCheckout {

    @Id
    private int id;
    private int buyer;
    private int seller;
    private String payment;
    private String shipment;
    private int products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}
	
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}
	
	public int getProducts() {
		return products;
	}

	public void setProducts(int products) {
		this.products = products;
	}
	
	@Override
    public String toString() {
        return "OrderCheckout{" + "id='" + id + '\'' + "buyer='" + buyer + '\'' + "seller='" + seller + '\'' + "payment='" + payment + '\'' + "shipment='" + shipment + '\'' + ", products='" + products + '\'' + '}';
    }
}