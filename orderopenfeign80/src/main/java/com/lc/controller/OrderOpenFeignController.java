package com.lc.controller;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import com.lc.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/openfeign")
public class OrderOpenFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getPaymentFeign")
    public CommonResult<Payment> getPaymentFeign(Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/insertPaymentFeign")
    public CommonResult insertPaymentFeign(Payment payment) {
        return paymentFeignService.insertPayment(payment);
    }

    @GetMapping("/paymentFeignTimeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
