package com.project.microservices.product.controller;

import com.project.microservices.product.dto.ProductRequest;
import com.project.microservices.product.dto.ProductResponse;
import com.project.microservices.product.model.Product;
import com.project.microservices.product.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productService.getAllProducts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@PathVariable String id){
        Product product = productService.getProductById(id);

        if(product != null) {
            productService.deleteProductById(id);
        }
    }
}
