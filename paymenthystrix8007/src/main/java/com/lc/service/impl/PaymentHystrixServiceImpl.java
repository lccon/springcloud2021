package com.lc.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lc.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String payment_ok(Long id) {
        return "线程池："+ Thread.currentThread().getName() + " paymentInfo_OK, id=" + id + "😄";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentFallBack", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String payment_error(Long id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName() + " paymentInfo_error, id=" + id + "😭";
    }

    private String paymentFallBack(Long id) {
        return "线程池："+ Thread.currentThread().getName() + " 调用超时请稍后重试, 😭";
    }


    @HystrixCommand(fallbackMethod = "breakFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id 不能是负数");
        }
        String s = IdUtil.randomUUID();
        return Thread.currentThread().getName() + "调用成功，serial=" + s;
    }

    public String breakFallback(Long id) {
        return "代码异常，id=" + id;
    }
}
