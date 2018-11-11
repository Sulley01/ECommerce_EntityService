package com.javahelps.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.restservice.entity.WishlistProducts;
import com.javahelps.restservice.repository.WishlistProductsRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/wishlists/products")
public class WishlistProductsController {

    @Autowired
    private WishlistProductsRepository repository;

    @GetMapping
    public Iterable<WishlistProducts> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public WishlistProducts find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public WishlistProducts create(@RequestBody WishlistProducts wishlistProducts) {
        return repository.save(wishlistProducts);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public WishlistProducts update(@PathVariable("id") int id, @RequestBody WishlistProducts wishlistProducts) throws BadHttpRequest {
        if (repository.exists(id)) {
        	wishlistProducts.setId(id);
            return repository.save(wishlistProducts);
        } else {
            throw new BadHttpRequest();
        }
    }

}