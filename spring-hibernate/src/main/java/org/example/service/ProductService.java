package org.example.service;



import org.example.entity.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ProductService {
    Product get(long id);
    Product add(Product product);
    @PreAuthorize("hasRole('ROLE_USER')")
    List<Product> list();
}