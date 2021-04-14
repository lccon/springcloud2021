package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Configclient3355Application {

	public static void main(String[] args) {
		SpringApplication.run(Configclient3355Application.class, args);
	}

}
