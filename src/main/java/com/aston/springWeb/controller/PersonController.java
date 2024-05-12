package com.aston.springWeb.controller;


import com.aston.springWeb.entity.Product;
import com.aston.springWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    ProductService productService;

    @GetMapping("/find")
    public List<Product> findPersonName(){
        System.out.println(productService.getAllProducts());
        return productService.getAllProducts();
    }

}
