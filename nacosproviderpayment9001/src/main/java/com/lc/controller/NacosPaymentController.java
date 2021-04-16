package com.lc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
@RequestMapping("/api/nacos/payment")
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    /*@Value("${config.info}")
    private String configInfo;*/

    @GetMapping("/getServerPort")
    public String getServerPort(@RequestParam(value = "id") Long id) {
        //return configInfo + ", port=" + serverPort;
        return "port=" + serverPort + ", id=" + id;
    }


}
