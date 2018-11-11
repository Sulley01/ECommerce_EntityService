package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wishlist {

    @Id
    private int id;
    private int products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public int getProducts() {
		return products;
	}

	public void setProducts(int products) {
		this.products = products;
	}
	
	@Override
    public String toString() {
        return "Wishlist{" + "id='" + id + '\'' + ", products='" + products + '\'' + '}';
    }
}