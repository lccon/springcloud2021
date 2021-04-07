package com.lc;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name="cloud-payment-service", configuration = MySelfRule.class)
public class Order80Application {

	public static void main(String[] args) {
		SpringApplication.run(Order80Application.class, args);
	}

}
