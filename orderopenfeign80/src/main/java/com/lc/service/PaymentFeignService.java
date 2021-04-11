package com.lc.service;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/api/payment/insertPayment")
    CommonResult insertPayment(Payment payment);

    @GetMapping("/api/payment/paymentFeignTimeout")
    String paymentFeignTimeout();

    @GetMapping("/api/payment/getPaymentById")
    CommonResult getPaymentById(@RequestParam(value = "id") Long id);
}


