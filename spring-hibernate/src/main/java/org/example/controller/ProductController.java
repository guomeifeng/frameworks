package org.example.controller;

import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.example.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Object add(@RequestBody  Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }

}