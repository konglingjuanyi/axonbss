package com.ai.bss.api.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
@EnableAutoConfiguration
public class BaseApiMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BaseApiMain.class, args);
	}

}
