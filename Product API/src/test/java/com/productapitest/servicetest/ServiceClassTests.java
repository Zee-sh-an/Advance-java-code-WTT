package com.productapitest.servicetest;

import com.productapi.entities.Product;
import com.productapi.entities.Status;
import com.productapi.repo.ProductRepository;
import com.productapi.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ServiceClassTests {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;


    @Test
    public void getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(56, "Box", Status.ACTIVE));

        when(productRepository.findAll()).thenReturn(productList);
        ResponseEntity responseEntity = productService.getAllProducts();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getAllProductsWhenDataEmpty() {
        List<Product> productList = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(productList);
        ResponseEntity responseEntity = productService.getAllProducts();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void getAllProductsException() {

        when(productRepository.findAll()).thenThrow(RuntimeException.class);
        ResponseEntity responseEntity = productService.getAllProducts();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void getProductById() {
        int id = 45;
        Product product = new Product(45, "Box", Status.ACTIVE);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.productById(id);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void addProduct() {

        Product product = new Product(45, "Box", Status.ACTIVE);
        when(productRepository.save(product)).thenReturn(product);
        ResponseEntity responseEntity = productService.addProduct(product);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void addProductWhenDataNull() {

        when(productRepository.save(null)).thenReturn(null);
        ResponseEntity responseEntity = productService.addProduct(null);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void addProductExceptionOccur() {
        Product product = new Product(56, "Rajput", Status.ACTIVE);

        when(productRepository.save(product)).thenThrow(RuntimeException.class);
        ResponseEntity responseEntity = productService.addProduct(product);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteProduct() {//productRepo needs void provide void
        int id = 4;
        Product product = new Product(4, "Box", Status.ACTIVE);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.deleteProduct(4);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deleteProductWhenDataNotFound() {//check
        int id = 4;
        Product product = null;

        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));
        ResponseEntity responseEntity = productService.deleteProduct(id);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);

    }

    @Test
    public void deleteProductException() {
        int id = 56;

        when(productRepository.findById(id)).thenThrow(RuntimeException.class);
        ResponseEntity responseEntity = productService.deleteProduct(id);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Test
    public void updateProduct() {
        int id = 4;
        Product product = new Product(4, "Box", Status.ACTIVE);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.updateProduct(product, id);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void updateProductException() {
        int id = 4;
        Product product = new Product(4, "Box", Status.ACTIVE);

        when(productRepository.findById(id)).thenThrow(RuntimeException.class);
        ResponseEntity responseEntity = productService.updateProduct(product, 4);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
