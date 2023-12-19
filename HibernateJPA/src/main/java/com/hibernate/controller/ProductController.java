package com.hibernate.controller;

import com.hibernate.entites.Product;
import com.hibernate.repo.ProductRepository;
import com.hibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id,@RequestBody Product product){
        return productService.updateProduct(product,id);
    }

    @GetMapping("/productByName/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/productByPrice/{price}")
    public ResponseEntity findByPrice(@PathVariable int price){
        return productService.findByPrice(price);
    }


}
