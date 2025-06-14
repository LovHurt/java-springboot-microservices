package com.lovehurts.microservices.product.repository;

import com.lovehurts.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
