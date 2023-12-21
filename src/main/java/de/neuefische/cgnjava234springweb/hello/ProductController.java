package de.neuefische.cgnjava234springweb.hello;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id: " + id + " not found!"));
    }

    @PostMapping("/api/products")
    public Product postProduct(@RequestBody Product product) {
        productRepo.save(product);
        return product;
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProductById(@PathVariable String id ){
        productRepo.deleteById(id);
    }
}
