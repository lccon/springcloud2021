package com.lc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "cloud-provider-payment-hystrix", fallback = FallBackHystrixService.class)
public interface PaymentHystrixService {

    @GetMapping("/api/payment/hystrix/paymentOk")
    String payment_ok(@RequestParam(value="id") Long id);

    @GetMapping("/api/payment/hystrix/paymentError")
    String payment_error(@RequestParam(value="id") Long id);

}
