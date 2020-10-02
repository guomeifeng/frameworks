package org.example.service;



import org.example.entity.Product;

import java.util.List;

public interface IProductService {
    Product get(long id);
    Product add(Product product);
    List<Product> list();
}