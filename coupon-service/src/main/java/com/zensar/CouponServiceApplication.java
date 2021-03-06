package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class CouponServiceApplication {

	@Value("${test.myLanguage}")
	private String language;

	@Autowired
	private MyConfig config;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@GetMapping("/")
	public String getLang() {
		return "My language is " + language + " and my company is " + config.getCompany();
	}

}
