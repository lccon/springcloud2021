package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Streamprovider8801Application {

	public static void main(String[] args) {
		SpringApplication.run(Streamprovider8801Application.class, args);
	}

}
