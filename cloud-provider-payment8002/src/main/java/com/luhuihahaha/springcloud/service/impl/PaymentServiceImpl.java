package com.luhuihahaha.springcloud.service.impl;

import com.luhuihahaha.springcloud.dao.PaymentDao;
import com.luhuihahaha.springcloud.entities.Payment;
import com.luhuihahaha.springcloud.service.PaymentSerice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentSerice {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentId(Long id) {
        return paymentDao.getPaymentId(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentDao.getAllPayment();
    }
}
