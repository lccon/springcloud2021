package com.lc.mapper;

import com.lc.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    int insertPayment(Payment payment);

    Payment getPaymentById(Long id);
}
