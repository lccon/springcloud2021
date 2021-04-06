package com.lc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/paymentzk")
public class PaymentZkController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPaymentZk")
    public String getPaymentZk() {
        return "调用成功，port=" + serverPort + ", 序列码=" + UUID.randomUUID();
    }

}
