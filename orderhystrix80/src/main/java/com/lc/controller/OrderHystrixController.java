package com.lc.controller;

import com.lc.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@DefaultProperties(defaultFallback = "globalFallMethod")
@RestController
@RequestMapping("/api/order/hystrix")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/paymentOk")
    public String payment_ok(@RequestParam(value="id") Long id) {
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping("/paymentError")
    /*@HystrixCommand(fallbackMethod = "orderFallBack", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2500")
    })*/
    @HystrixCommand
    public String payment_error(@RequestParam(value="id") Long id){
        return paymentHystrixService.payment_error(id);
    }

    public String orderFallBack(Long id) {
        return "请求超时，请稍后重试，serial=" + UUID.randomUUID().toString();
    }

    public String globalFallMethod() {
        return "全局方法，超时喽";
    }
}
