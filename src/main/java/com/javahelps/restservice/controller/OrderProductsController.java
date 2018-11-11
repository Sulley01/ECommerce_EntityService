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

import com.javahelps.restservice.entity.OrderProducts;
import com.javahelps.restservice.repository.OrderProductsRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/orders/products")
public class OrderProductsController {

    @Autowired
    private OrderProductsRepository repository;

    @GetMapping
    public Iterable<OrderProducts> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderProducts find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public OrderProducts create(@RequestBody OrderProducts orderProducts) {
        return repository.save(orderProducts);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public OrderProducts update(@PathVariable("id") int id, @RequestBody OrderProducts orderProducts) throws BadHttpRequest {
        if (repository.exists(id)) {
        	orderProducts.setId(id);
            return repository.save(orderProducts);
        } else {
            throw new BadHttpRequest();
        }
    }

}