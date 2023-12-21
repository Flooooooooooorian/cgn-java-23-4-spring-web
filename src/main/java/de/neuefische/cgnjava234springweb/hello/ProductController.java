package de.neuefische.cgnjava234springweb.hello;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    List<Product> products = new ArrayList<>();

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Product with id: " + id + " not found!"));
    }

    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProductById(@PathVariable String id ){
        products.removeIf(product -> product.getId().equals(id));
    }
}
