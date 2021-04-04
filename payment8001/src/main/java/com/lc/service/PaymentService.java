package com.lc.service;

import com.lc.domain.Payment;

public interface PaymentService {

    int insertPayment(Payment payment);

    Payment getPaymentById(Long id);
}
