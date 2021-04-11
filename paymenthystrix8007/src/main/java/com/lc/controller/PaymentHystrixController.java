package com.lc.controller;

import com.lc.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("/api/payment/hystrix")
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/paymentOk")
    public String payment_ok(@RequestParam(value="id") Long id) {
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping("/paymentError")
    public String payment_error(@RequestParam(value="id") Long id) {
        return paymentHystrixService.payment_error(id);
    }

    @GetMapping("/paymentCircuitBreaker")
    public String paymentCircuitBreaker(Long id) {
        return paymentHystrixService.paymentCircuitBreaker(id);
    }
}
