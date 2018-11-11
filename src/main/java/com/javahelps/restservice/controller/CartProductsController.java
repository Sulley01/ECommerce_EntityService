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

import com.javahelps.restservice.entity.CartProducts;
import com.javahelps.restservice.repository.CartProductsRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/carts/products")
public class CartProductsController {

    @Autowired
    private CartProductsRepository repository;

    @GetMapping
    public Iterable<CartProducts> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public CartProducts find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public CartProducts create(@RequestBody CartProducts cartProducts) {
        return repository.save(cartProducts);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public CartProducts update(@PathVariable("id") int id, @RequestBody CartProducts cartProducts) throws BadHttpRequest {
        if (repository.exists(id)) {
            cartProducts.setId(id);
            return repository.save(cartProducts);
        } else {
            throw new BadHttpRequest();
        }
    }

}