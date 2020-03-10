package com.eric.springcloud.service;

import com.eric.common.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author eric.li
 * @date 2020/3/9
 */
public interface PaymentService {
    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
