package com.example.redisdemo;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import responsitory.ProductH;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping
public class RedisDemoApplication {
    @Autowired
    private ProductH h;

    @PostMapping
    public Product save(@RequestBody Product product){
        return  h.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return h.fillAll();
    }
    @GetMapping
    public Product fillProduct(@PathVariable int id){
        return h.findProductById(id);
    }
    @DeleteMapping
    public String remove(@PathVariable int id){
        return h.deleteproduct(id);
    }
    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }


}
