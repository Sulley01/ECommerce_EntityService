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

import com.javahelps.restservice.entity.OrderCheckout;
import com.javahelps.restservice.repository.OrderCheckoutRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/orders")
public class OrderCheckoutController {

    @Autowired
    private OrderCheckoutRepository repository;

    @GetMapping
    public Iterable<OrderCheckout> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderCheckout find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public OrderCheckout create(@RequestBody OrderCheckout orderCheckout) {
        return repository.save(orderCheckout);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public OrderCheckout update(@PathVariable("id") int id, @RequestBody OrderCheckout orderCheckout) throws BadHttpRequest {
        if (repository.exists(id)) {
        	orderCheckout.setId(id);
            return repository.save(orderCheckout);
        } else {
            throw new BadHttpRequest();
        }
    }

}