package com.lc.service;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/api/payment/getPaymentById")
    CommonResult getPaymentById(Long id);

    @GetMapping("/api/payment/insertPayment")
    CommonResult insertPayment(Payment payment);

}
