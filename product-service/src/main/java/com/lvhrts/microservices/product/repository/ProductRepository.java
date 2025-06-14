package com.lvhrts.microservices.product.repository;

import com.lvhrts.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
