package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponRestClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CouponRestClient restClient;

	@GetMapping("/all")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}

	@PostMapping("/")
	@Retry(name = "productapi", fallbackMethod = "getDefaultProducts")
	public Product insertProduct(@RequestBody Product product) {

		System.out.println("Product price is -----" + product.getPrice());

		Coupon coupon = restClient.getCoupon(product.getCouponCode());

		product.setPrice(product.getPrice() - coupon.getDiscount());

		return productService.insertProduct(product);
	}

	public Product getDefaultProducts(Throwable t) {
		return new Product();
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}

}
