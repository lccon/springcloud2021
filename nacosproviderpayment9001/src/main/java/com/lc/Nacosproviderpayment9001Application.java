package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Nacosproviderpayment9001Application {

	public static void main(String[] args) {
		SpringApplication.run(Nacosproviderpayment9001Application.class, args);
	}

}
