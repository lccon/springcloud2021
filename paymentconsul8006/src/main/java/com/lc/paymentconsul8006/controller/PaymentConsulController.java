package com.lc.paymentconsul8006.controller;

import com.lc.domain.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/api/paymentconsul")
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPaymentConsul")
    @ResponseBody
    public CommonResult getPaymentConsul() {
        return new CommonResult(200, "成功", "调用成功，port="+ serverPort +", UUID="+ UUID.randomUUID());
    }

}
