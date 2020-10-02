package com.example.demo.services.impl;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepo;
import com.example.demo.services.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return this.productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public Product findOne(Long id) {
        return this.productRepo.getOne(id);
    }

    @Override
    public void delete(Product product) {
        this.productRepo.delete(product);
    }

}
