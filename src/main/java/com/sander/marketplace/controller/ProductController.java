package com.sander.marketplace.controller;

import com.sander.marketplace.model.Product;
import com.sander.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products")
    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }
}
