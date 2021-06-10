package com.edureka.userms.resource;

import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;
import com.edureka.userms.service.OrdermsClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class UserResource {

	private final UserRepository userRepository;
	//Day 1
	//private final RestTemplate restTemplate;
	//For Circuit Breaker Day 2
	private final OrdermsClient ordermsClient;
	
	public UserResource(UserRepository userRepository, RestTemplate restTemplate, OrdermsClient ordermsClient)
	{
		this.userRepository=userRepository;
		//this.restTemplate=restTemplate;
		this.ordermsClient=ordermsClient;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	//Code for return restTemplate for Order Microservice
	
	@GetMapping("/orders")
	public Object getAllOrders()
	{
		System.out.println("Calling OrderMS");
		//Day 1
		//return restTemplate.getForObject("http://orderms/orders", Object.class);
		//For Circuit Breaker (Day 2)
		return ordermsClient.getAllOrders();
		
	}
}
