package org.example.service;



import java.util.List;
import org.example.entity.Product;

public interface IProductService {
    Product get(long id);
    Product add(Product product);
    List<Product> list();
}