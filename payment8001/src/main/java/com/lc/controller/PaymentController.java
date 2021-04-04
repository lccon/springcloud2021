package com.lc.controller;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import com.lc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/insertPayment")
    @ResponseBody
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int count = paymentService.insertPayment(payment);
        return new CommonResult(200, "新增成功", count);
    }

    @GetMapping("/getPaymentById")
    @ResponseBody
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "获取详情成功", payment);
    }
}
