package com.ai.bss.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.ai.bss"})
@EnableJpaRepositories(basePackages={"com.ai.bss.query"})
@EntityScan({"com.ai.bss"})
@EnableDiscoveryClient
public class PartyApiService {
	public static void main(String[] args) throws Exception {
		SpringApplication notificationMicroService = new SpringApplication(PartyApiService.class);
        notificationMicroService.addListeners(new ApplicationPidFileWriter("party-micro-service.pid"));
        notificationMicroService.run(args);
	}

}
