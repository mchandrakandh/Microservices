package com.edureka.userms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix


public class UsermsApplication {

	//Code for Load balancer starts
	
	@Bean
	@LoadBalanced // Enable Ribbon Load Balancer
	public RestTemplate getRestTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
	
	//Code for Load balancer ends
	
	public static void main(String[] args) {
		SpringApplication.run(UsermsApplication.class, args);
	}

}
