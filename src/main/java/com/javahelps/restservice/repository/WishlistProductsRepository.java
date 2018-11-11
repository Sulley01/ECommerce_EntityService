package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.javahelps.restservice.entity.WishlistProducts;

@RestResource(exported = false)
public interface WishlistProductsRepository extends JpaRepository<WishlistProducts, Integer> {

}