package com.eric.springcloud.controller;


import com.eric.common.entities.CommonResult;
import com.eric.common.entities.Payment;
import com.eric.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author eric.li
 * @date 2020/3/9
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("result : {}", result);
        if (result > 0){
            return new CommonResult(200, "insert success.", result);
        }else {
            return new CommonResult(444, "insert failed.", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment){
            return new CommonResult(200, "get payment success.", payment);
        }else {
            return new CommonResult(444, "get payment failed", null);
        }
    }

}
