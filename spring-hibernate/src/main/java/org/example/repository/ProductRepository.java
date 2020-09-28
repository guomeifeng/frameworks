package org.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "from Product p where p.productId =:id")
    public Product findById2(Long id);
    @Query(value = "select * from product p where p.product_name=?1", nativeQuery = true)
    public List<Product> findProductsByName(String productName);
    public List<Product> findAll();
}
