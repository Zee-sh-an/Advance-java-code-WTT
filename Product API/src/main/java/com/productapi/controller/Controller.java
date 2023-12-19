package com.productapi.controller;

import com.productapi.entities.Product;
import com.productapi.repo.ProductRepository;
import com.productapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/products")
    public ResponseEntity getProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity getProductById(@PathVariable("productId") int productId) {

        return productService.productById(productId);

    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable("productId") int productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatingProduct(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProduct(product, id);
    }

}
