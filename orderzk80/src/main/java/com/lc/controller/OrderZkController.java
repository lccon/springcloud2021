package com.lc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/orderzk")
public class OrderZkController {

    private static final String PAYMENT_ZK_URL = "http://cloud-provider-paymentzk";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getPaymentZk")
    @ResponseBody
    public String getPaymentZk() {
        return restTemplate.getForObject(PAYMENT_ZK_URL + "/api/paymentzk/getPaymentZk", String.class);
    }

}
