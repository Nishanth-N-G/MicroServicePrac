package com.microserviceExmpl.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserviceExmpl.productservice.dto.ProductRequest;
import com.microserviceExmpl.productservice.dto.ProductResponse;
import com.microserviceExmpl.productservice.model.Product;
import com.microserviceExmpl.productservice.repo.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
							.name(productRequest.getName())
							.description(productRequest.getDescription())
							.price(productRequest.getPrice())
							.build();
		
		productRepo.save(product);
		log.info("Product {} is saved", product.getId()	);
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products= productRepo.findAll();
		
		return products.stream().map(product-> getProductResp(product)).collect(Collectors.toList());
	}

	private ProductResponse getProductResp(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}
