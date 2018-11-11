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

import com.javahelps.restservice.entity.Seller;
import com.javahelps.restservice.repository.SellerRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/sellers")
public class SellerController {

    @Autowired
    private SellerRepository repository;

    @GetMapping
    public Iterable<Seller> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Seller find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Seller create(@RequestBody Seller seller) {
        return repository.save(seller);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Seller update(@PathVariable("id") int id, @RequestBody Seller seller) throws BadHttpRequest {
        if (repository.exists(id)) {
            seller.setId(id);
            return repository.save(seller);
        } else {
            throw new BadHttpRequest();
        }
    }

}