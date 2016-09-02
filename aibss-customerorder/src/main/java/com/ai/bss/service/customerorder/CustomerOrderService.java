package com.ai.bss.service.customerorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.ai.bss"})
@EnableJpaRepositories(basePackages = {"com.ai.bss"})
@EntityScan(basePackages = {"com.ai.bss"})
@EnableDiscoveryClient
public class CustomerOrderService {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CustomerOrderService.class, args);
	}

}
