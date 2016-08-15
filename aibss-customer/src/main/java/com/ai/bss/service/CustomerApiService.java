package com.ai.bss.service;

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
public class CustomerApiService {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CustomerApiService.class, args);
	}

}
