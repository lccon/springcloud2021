package com.lc.controller;

import com.lc.domain.CommonResult;
import com.lc.domain.Payment;
import com.lc.lb.LoadBalancer;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consumer/order")
public class OrderController {

    //private static final String PAYMENT_URL = "http://127.0.0.1:8001";
    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/insertPayment")
    public CommonResult<Payment> insertPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/api/payment/insertPayment", payment, CommonResult.class);
    }

    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return restTemplate.getForObject(PAYMENT_URL + "/api/payment/getPaymentById?id={id}", CommonResult.class, map);
    }

    @GetMapping("/getPaymentSp")
    public String getPaymentSp() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/api/payment/getPaymentSp", String.class);
    }
}
