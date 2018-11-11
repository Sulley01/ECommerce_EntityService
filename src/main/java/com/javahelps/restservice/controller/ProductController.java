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

import com.javahelps.restservice.entity.Product;
import com.javahelps.restservice.repository.ProductRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Product find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product) throws BadHttpRequest {
        if (repository.exists(id)) {
            product.setId(id);
            return repository.save(product);
        } else {
            throw new BadHttpRequest();
        }
    }

}