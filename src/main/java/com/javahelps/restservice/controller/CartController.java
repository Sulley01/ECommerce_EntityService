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

import com.javahelps.restservice.entity.Cart;
import com.javahelps.restservice.repository.CartRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/carts")
public class CartController {

    @Autowired
    private CartRepository repository;

    @GetMapping
    public Iterable<Cart> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Cart find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Cart create(@RequestBody Cart cart) {
        return repository.save(cart);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Cart update(@PathVariable("id") int id, @RequestBody Cart cart) throws BadHttpRequest {
        if (repository.exists(id)) {
            cart.setId(id);
            return repository.save(cart);
        } else {
            throw new BadHttpRequest();
        }
    }

}