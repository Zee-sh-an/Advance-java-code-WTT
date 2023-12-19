package com.productapitest.controllertest;

import com.productapi.controller.Controller;
import com.productapi.entities.Product;
import com.productapi.entities.Status;
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

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class ControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private Controller controller;

    @Test
    public void getAllProducts() {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(55, "Karan", Status.ACTIVE));
        productList.add(new Product(5, "Kapoor", Status.ACTIVE));

        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
        when(productService.getAllProducts()).thenReturn(responseEntity);
        ResponseEntity responseEntity1 = controller.getProduct();
        Assert.assertEquals(responseEntity1.getStatusCode(), responseEntity.getStatusCode());
    }


    @Test
    public void getProductById() {
        int id = 9;

        ResponseEntity responseEntity1 = new ResponseEntity<>(HttpStatus.OK);
        when(productService.productById(id)).thenReturn(responseEntity1);
        ResponseEntity responseEntity = controller.getProductById(id);
        Assert.assertEquals(responseEntity.getStatusCode(), responseEntity1.getStatusCode());
    }

    @Test
    public void addProduct() {

        Product product = new Product(56, "Rajput", Status.ACTIVE);
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
        when(productService.addProduct(product)).thenReturn(responseEntity);
        ResponseEntity response = controller.addProduct(product);
        Assert.assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
    }


    @Test
    public void deleteProduct() {
        int id = 56;

        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
        when(productService.deleteProduct(id)).thenReturn(responseEntity);
        ResponseEntity response = controller.deleteProduct(id);
        Assert.assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
    }


    @Test
    public void updateProduct() {
        int id = 4;
        Product product = new Product(4, "Rajput", Status.ACTIVE);

        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
        when(productService.updateProduct(product, id)).thenReturn(responseEntity);
        ResponseEntity response = controller.updatingProduct(product, 4);
        Assert.assertEquals(responseEntity.getStatusCode(), responseEntity.getStatusCode());
    }
}
