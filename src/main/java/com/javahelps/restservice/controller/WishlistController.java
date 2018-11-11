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

import com.javahelps.restservice.entity.Wishlist;
import com.javahelps.restservice.repository.WishlistRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/wishlists")
public class WishlistController {

    @Autowired
    private WishlistRepository repository;

    @GetMapping
    public Iterable<Wishlist> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Wishlist find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Wishlist create(@RequestBody Wishlist wishlist) {
        return repository.save(wishlist);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Wishlist update(@PathVariable("id") int id, @RequestBody Wishlist wishlist) throws BadHttpRequest {
        if (repository.exists(id)) {
        	wishlist.setId(id);
            return repository.save(wishlist);
        } else {
            throw new BadHttpRequest();
        }
    }

}