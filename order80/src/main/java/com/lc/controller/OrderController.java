package com.lc.controller;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/consumer/order")
public class OrderController {

    //private static final String PAYMENT_URL = "http://127.0.0.1:8001";
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/insertPayment")
    public CommonResult<Payment> insertPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/api/payment/insertPayment", payment, CommonResult.class);
    }

    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return restTemplate.getForObject(PAYMENT_URL + "/api/payment/getPaymentById?id={id}", CommonResult.class, map);
    }

}
