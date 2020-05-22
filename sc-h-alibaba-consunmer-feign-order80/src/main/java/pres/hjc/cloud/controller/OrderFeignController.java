package pres.hjc.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.service.PaymentOpenFeignService;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 19:44
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentOpenFeignService service;

    @GetMapping("/consumer/pm/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        //* open feign m默认等待处理1s ， 不然超时报错
        return service.getPaymentById(id);
    }
}
