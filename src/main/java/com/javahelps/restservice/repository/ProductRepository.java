package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.javahelps.restservice.entity.Product;

@RestResource(exported = false)
public interface ProductRepository extends JpaRepository<Product, Integer> {

}