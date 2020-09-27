package org.example.repository;



import org.example.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean create(Product product);
    public Product findById2(Long id);
    public Product findById(long id);
    public List<Product> findAll();
}
