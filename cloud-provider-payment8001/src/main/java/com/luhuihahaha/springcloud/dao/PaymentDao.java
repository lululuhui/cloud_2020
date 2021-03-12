package com.luhuihahaha.springcloud.dao;

import com.luhuihahaha.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentId(@Param("id") Long id);

    public List<Payment> getAllPayment();
}
