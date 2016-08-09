package com.ai.bss.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.ai.bss"})
@EnableDiscoveryClient
public class PartyApiService {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PartyApiService.class, args);
	}

}
