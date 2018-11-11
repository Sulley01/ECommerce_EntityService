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

import com.javahelps.restservice.entity.Buyer;
import com.javahelps.restservice.repository.BuyerRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/buyers")
public class BuyerController {

    @Autowired
    private BuyerRepository repository;

    @GetMapping
    public Iterable<Buyer> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Buyer find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Buyer create(@RequestBody Buyer buyer) {
        return repository.save(buyer);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Buyer update(@PathVariable("id") int id, @RequestBody Buyer buyer) throws BadHttpRequest {
        if (repository.exists(id)) {
            buyer.setId(id);
            return repository.save(buyer);
        } else {
            throw new BadHttpRequest();
        }
    }

}