package com.lc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/nacos/consumer")
public class NacosOrderController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getPaymentServer")
    public String getPaymentServer(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return restTemplate.getForObject(serverUrl+"/api/nacos/payment/getServerPort?id={id}", String.class, map);
    }
}
