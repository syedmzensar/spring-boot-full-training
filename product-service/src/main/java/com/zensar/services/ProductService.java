package com.zensar.services;

import java.util.List;

import com.zensar.entity.Product;

public interface ProductService {

	Product insertProduct(Product product);
	
	List<Product> getAllProducts();
	
	void deleteProduct(int productId);

}
