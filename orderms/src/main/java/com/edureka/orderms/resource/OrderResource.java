package com.edureka.orderms.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.orderms.model.Order;
import com.edureka.orderms.repository.OrderRepository;

@RestController

public class OrderResource {

	private final OrderRepository orderRepository;
	
	public OrderResource (OrderRepository orderRepository)
	{
		this.orderRepository=orderRepository;
		
	}
	
	//Return list of Order when API /orders is called
	
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}
}
