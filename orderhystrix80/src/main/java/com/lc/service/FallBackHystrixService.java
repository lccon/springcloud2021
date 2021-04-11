package com.lc.service;

import org.springframework.stereotype.Component;

@Component
public class FallBackHystrixService implements PaymentHystrixService {
    @Override
    public String payment_ok(Long id) {
        return "payment_ok调用出错!";
    }

    @Override
    public String payment_error(Long id) {
        return "payment_error访问出错!";
    }
}
