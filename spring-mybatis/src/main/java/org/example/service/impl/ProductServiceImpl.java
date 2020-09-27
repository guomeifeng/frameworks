package org.example.service.impl;



import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.example.service.IProductService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public Product get(long id) {
        System.out.println("id:................."+id+productRepository.findById(id).toString());
        return productRepository.findById2(id);
    }

    @Override
    public boolean add(Product product) {
        return productRepository.create(product);
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }
}