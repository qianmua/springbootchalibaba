package pres.hjc.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/10
 * @time 19:06
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping( "/payment/create")
    public CommonResult<Integer> create( @RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info(" insert ->" + result);

        if ( result > 0){
            return new CommonResult<>(200,"success port :" + port , result);
        }else {
            return new CommonResult<>(500 , "fail" , null);
        }
    }

    @GetMapping( "/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info(" insert ->" + payment);

        if ( payment != null ){
            return new CommonResult<>(200,"success" , payment);
        }else {
            return new CommonResult<>(500 , "fail" , null);
        }
    }

    /**
     * 自定义负载均衡算法
     * @return
     */
    @GetMapping("/payment/get/lb")
    public String mylb(){
        return port;
    }

}
