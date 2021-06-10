package com.edureka.mqactive01;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJms
@RestController

public class MqActive01Application {

	@GetMapping("/publish/{message}")
	public void publish (@PathVariable String message)
	{
		System.out.println("Message from Browser:" + message);
		jmsTemplateForQueue.convertAndSend(queue_1, "Q--" + message);
		jmsTemplateForTopic.convertAndSend(topic, "T--" + message);
	}
	
	
	@Autowired
	private JmsTemplate jmsTemplateForQueue;
	
	@Autowired
	private JmsTemplate jmsTemplateForTopic;
	
	@Autowired
	private Queue queue_1;

	@Autowired
	private Topic topic;
	
	@Bean
	public Queue queue_1()
	{
		return new ActiveMQQueue ("queue_1");
		
	}
	
	@Bean
	public Topic topic()
	{
		return new ActiveMQTopic ("topic");
		
	}
		
	/*
	 * Factory
	 * @param configurer
	 * @param factory
	 * @return
	 */
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsTemplateForTopic(
			DefaultJmsListenerContainerFactoryConfigurer configurer, ConnectionFactory factory
			)
	{
		final DefaultJmsListenerContainerFactory cf = new DefaultJmsListenerContainerFactory();
		configurer.configure(cf, factory);
		cf.setPubSubDomain(true);
		return cf;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MqActive01Application.class, args);
	}

}
