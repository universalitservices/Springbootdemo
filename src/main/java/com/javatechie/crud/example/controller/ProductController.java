package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;

import com.javatechie.crud.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productcatalog")
public class ProductController {
    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        log.info("Adding product");
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(@RequestHeader Map<String,String> header) {
        log.info("retrieving all products");
        System.out.println(header);

        return service.getProducts();
    }

    @GetMapping("/product-id/{id}")
    public Product findProductById(@PathVariable int id) {
        log.info("finding product with id "+ id);

        return service.getProductById(id);
    }

    @GetMapping("/product-name/{name}")
    public Product findProductByName(@PathVariable String name) {
        log.info("finding product with name "+ name);
        return service.getProductByName(name);
    }

    @PutMapping("/product/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        log.info("Updating product with id "+ id);
        return service.updateProduct(id,product);
    }

    @PatchMapping ("/product/update/{id}")
    public Product patchProduct(@RequestBody Product product, @PathVariable int id) {
        log.info("Updating product with id "+ id);
        return service.patchProduct(id,product);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        log.info("deleting product with id "+ id);
        return service.deleteProduct(id);
    }
}
