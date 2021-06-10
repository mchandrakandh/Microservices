package com.edureka.mqclient02;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@SpringBootApplication
public class MqClient02Application {

	@JmsListener(destination = "queue_1")
	public void listen(String message) {
		System.out.println("Queue: " + message);
	}

	@JmsListener(destination = "topic", containerFactory = "jmsTemplateForTopic")
	public void listenTopic(String message) {
		System.out.println("Topic: " + message);
	}

	/**
	 * Required for Topic
	 * @param configurer
	 * @param factory
	 * @return
	 */
	@Bean
	public DefaultJmsListenerContainerFactory jmsTemplateForTopic(
			DefaultJmsListenerContainerFactoryConfigurer configurer,
			ConnectionFactory factory) {
		final DefaultJmsListenerContainerFactory cf = new DefaultJmsListenerContainerFactory();
		configurer.configure(cf, factory);
		cf.setPubSubDomain(true);
		return cf;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MqClient02Application.class, args);
	}

}
