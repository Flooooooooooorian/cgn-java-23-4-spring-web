package de.neuefische.cgnjava234springweb.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("hello")
    public String sayHelloTo(@RequestBody Product product) {
        System.out.println(product);
        return "Hello: " + product;
    }

    @GetMapping("/hello/{id}")
    public String getProductById(@PathVariable String id) {
        return "Product: " + id;
    }
}
