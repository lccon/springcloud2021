package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Streamconsumer8802Application {

	public static void main(String[] args) {
		SpringApplication.run(Streamconsumer8802Application.class, args);
	}

}
