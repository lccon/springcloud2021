package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Configclient3366Application {

	public static void main(String[] args) {
		SpringApplication.run(Configclient3366Application.class, args);
	}

}
