package com.edureka.userms.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edureka.userms.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class OrdermsClient {

	private final RestTemplate restTemplate;
	
	public OrdermsClient(RestTemplate restTemplate)
	{
		this.restTemplate=restTemplate;
	}
	
	//Circuit Breaker
	@HystrixCommand(fallbackMethod="getAllOrdersFromFallback", commandProperties= 
		{ @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")},
		
		//Bulkhead
		
		threadPoolKey="getAllUsersThreadPool",
		threadPoolProperties= {
				@HystrixProperty(name= "coreSize", value="30"),
				@HystrixProperty(name= "maxQueueSize", value="10"),
		}
		)
	public Object getAllOrders()
	{
		System.out.println("Calling OrderMS");
		return restTemplate.getForObject("http://orderms/orders", Object.class);
		
	}
	
	public Object getAllOrdersFromFallback()
	{
		System.out.println("Fallback invoked");
		final Order abc = new Order(1L, "FEST");
		return abc;
		
	}
		
	
}
