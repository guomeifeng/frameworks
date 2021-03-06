package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Product Management
 * Created by Kelly Guo on 27/09/2020
 */
@RestController
@RequestMapping("/product")
@Api(tags = {"Product APIs"}, value = "Product Module")
public class ProductController {

    @Resource
    private ProductService iProductService;

    @RequestMapping(value="/get/{id}")
    @ApiOperation(value = "Get Product Info By Id", notes = "Get ONE product by ID")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ApiOperation(value = "Add Product Into database", notes = "Save to database")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "Get Products List", notes = "Get All Products")
    public @ResponseBody List<Product> list() {
        return this.iProductService.list() ;
    }

}