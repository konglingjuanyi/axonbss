package com.ai.bss.query.customerorder.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ai.bss"})
@EnableJpaRepositories(basePackages = {"com.ai.bss"})
@EntityScan(basePackages = {"com.ai.bss"})
@EnableDiscoveryClient
public class CustomerOrderQueryServiceApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CustomerOrderQueryServiceApp.class, args);
	}
}
