package com.lc.controller;

import com.lc.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/orderconsul")
public class OrderConsulController {

    private static final String PAYMENT_CONSUL_URL = "http://cloud-payment-consul";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getPaymentConsul")
    @ResponseBody
    public CommonResult getPaymentConsul() {
        return restTemplate.getForObject(PAYMENT_CONSUL_URL + "/api/paymentconsul/getPaymentConsul", CommonResult.class);
    }

}
