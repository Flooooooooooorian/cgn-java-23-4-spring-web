package de.neuefische.cgnjava234springweb.hello;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {

}
