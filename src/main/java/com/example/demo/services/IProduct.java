package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();
    void save(Product product);
    Product findOne(Long id);
    void delete(Product product);
}
