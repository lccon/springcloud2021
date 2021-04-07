package com.lc.controller;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import com.lc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/insertPayment")
    @ResponseBody
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int count = paymentService.insertPayment(payment);
        return new CommonResult(200, "新增成功" + serverPort, count);
    }

    @GetMapping("/getPaymentById")
    @ResponseBody
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "获取详情成功" + serverPort, payment);
    }

    @GetMapping("/getPaymentSp")
    @ResponseBody
    public String getPaymentSp() {
        return serverPort;
    }
}
