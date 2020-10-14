package org.example.service.impl;


import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

//    @Resource
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product get(long id) {
        System.out.println("id:................."+id+productRepository.findById2(id).toString());
        return productRepository.findById2(id);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }


    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }
}