package com.productapi.services;

import com.productapi.entities.Error;
import com.productapi.entities.Product;
import com.productapi.entities.Status;
import com.productapi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity addProduct(Product product) {
        try {
//            if (product == null) {//Condition null should be should be change
            if (ObjectUtils.isEmpty(product.getProductName())) {
                Error error = Error.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message("Enter values of product values can not be null").build();
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }
//            }
            product.setStatus(Status.ACTIVE);
            productRepository.save(product);
            Error error = Error.builder().code(HttpStatus.OK.getReasonPhrase()).message("Product added successfully").build();
            return new ResponseEntity<>(error, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            Error error = Error.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).message("oops! data not added successfully").build();
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity getAllProducts() {

//        List<Product> products = productRepository.findAll();
        try {
            List<Product> products = productRepository.findAll();
            if (products.isEmpty()) {
                Error error = Error.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message("Sorry there is no Product").build();
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }
//            return ResponseEntity.status(HttpStatus.CREATED).body(products);
            return new ResponseEntity<>(products, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            Error error = Error.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).message("Sorry Internel Server Error occured").build();
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity productById(int id) {

        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isEmpty()) {
                Error error = Error.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message("Sorry there is no Product of id : " + id).build();
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.status(HttpStatus.OK).body(product);

        } catch (Exception e) {
            e.printStackTrace();
            Error error = Error.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).message("Sorry Internel Server Error occured").build();
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity deleteProduct(int id) {

        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isEmpty()) {
                Error error = Error.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message("data not found for this id " + id).build();
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }

            productRepository.deleteById(id);
            Error error = Error.builder().code(HttpStatus.OK.getReasonPhrase()).message("deleted successfully").build();
            return new ResponseEntity<>(error, HttpStatus.OK);
        } catch (Exception e) {
            Error error = Error.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).message("delete api failed").build();
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity updateProduct(Product product, int id) {

        try {

            Optional<Product> productbyId = productRepository.findById(id);
            if (productbyId.isEmpty()) {
                Error error = Error.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message("Product not found of id " + id).build();
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }
            product.setStatus(Status.ACTIVE);
            product.setProductId(id);
            Product response = productRepository.save(product);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(product);
        }
    }
}
