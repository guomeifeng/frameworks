package org.example.repository;

import org.example.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class ProductRepositoryTest {

    @Resource
    private ProductRepository productRepository;

    @Test
    public void testFindAll(){
        List<Product>  result = productRepository.findAll();
        System.out.println(result.toString());
        assert(null!=result);
    }
    @Test
    public void testFindById(){
        Product  result = productRepository.findById2(0l);
        assert(null!=result);
        System.out.println(result.toString());
    }
    @Test
    public void testFindProductsByName(){
        List<Product>  result = productRepository.findProductsByName("nameaaaa");
        assert(null!=result);
        System.out.println(result.toString());
    }
    @Test
    public void testSave(){
        Product product = new Product();
//        product.setProductId(3l);
        product.setProductName("nameb");
        product.setProductDesc("Test from JUnit4");
        Product  result = productRepository.save(product);
        System.out.println(result.toString());
    }
}
