package com.lc.service.Impl;

import com.lc.domain.Payment;
import com.lc.mapper.PaymentMapper;
import com.lc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int insertPayment(Payment payment) {
        int count = paymentMapper.insertPayment(payment);
        return count;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
