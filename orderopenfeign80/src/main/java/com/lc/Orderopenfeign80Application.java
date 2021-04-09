package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Orderopenfeign80Application {

	public static void main(String[] args) {
		SpringApplication.run(Orderopenfeign80Application.class, args);
	}

}
