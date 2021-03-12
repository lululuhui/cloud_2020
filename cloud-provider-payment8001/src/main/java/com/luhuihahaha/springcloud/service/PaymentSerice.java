package com.luhuihahaha.springcloud.service;

import com.luhuihahaha.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentSerice {

    public int create(Payment payment);

    public Payment getPaymentId(@Param("id") Long id);

    public List<Payment> getAllPayment();
}
