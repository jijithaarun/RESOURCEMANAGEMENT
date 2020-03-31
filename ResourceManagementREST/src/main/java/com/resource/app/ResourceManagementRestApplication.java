package com.resource.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ResourceManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceManagementRestApplication.class, args);
		System.out.println("resource management system");
	}

}
