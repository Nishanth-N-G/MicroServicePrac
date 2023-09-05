package com.microserviceExmpl.productservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microserviceExmpl.productservice.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product,String>{

}
