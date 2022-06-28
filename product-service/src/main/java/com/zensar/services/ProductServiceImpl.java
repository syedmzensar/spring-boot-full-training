package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Product;
import com.zensar.exception.ProductException;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		if (productRepository.findAll().isEmpty()) {
			throw new ProductException("List is empty");
		}
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(int productId){
		Product product = new Product();
		if(product.getProductId() == productId )
			productRepository.deleteById(productId);
		else
			throw new ProductException("Delete is not working");
		

	}

}
