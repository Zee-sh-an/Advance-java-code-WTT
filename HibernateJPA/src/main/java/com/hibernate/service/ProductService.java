package com.hibernate.service;

import com.hibernate.entites.Product;
import com.hibernate.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity addProduct(Product product){
        try {
                if (ObjectUtils.isEmpty(product.getName())||ObjectUtils.isEmpty(product.getPrice())){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            productRepository.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity getAllProduct(){

        try {
            List<Product> productList=productRepository.findAll();
            if (productList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            productRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity deleteProduct(int id){

        try {
            Optional<Product> byId = productRepository.findById(id);
            if (byId.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity updateProduct(Product product,int id){

        try {
            Optional optional=productRepository.findById(id);
            if (optional.isEmpty()){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            product.setId(id);
            Product product1 = productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body(product1);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity findByName(String name){
        try {
            List<Product> products = productRepository.findByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity findByPrice(int price){
        try {
            List<Product> byPriceGreaterThan = productRepository.findByPriceGreaterThan(price);
            return ResponseEntity.status(HttpStatus.OK).body(byPriceGreaterThan);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
