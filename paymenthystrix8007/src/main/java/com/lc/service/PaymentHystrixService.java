package com.lc.service;

public interface PaymentHystrixService {

    String payment_ok(Long id);

    String payment_error(Long id);

    String paymentCircuitBreaker(Long id);

}
