package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Nacosconsumerorder83Application {

	public static void main(String[] args) {
		SpringApplication.run(Nacosconsumerorder83Application.class, args);
	}

}
