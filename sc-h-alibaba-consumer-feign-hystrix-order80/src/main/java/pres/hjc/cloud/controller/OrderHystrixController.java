package pres.hjc.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 20:51
 */
@RestController
@Slf4j
// 全局 fall bach
@DefaultProperties( defaultFallback = "globalsFallBackMethod" , commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
})
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    /**
     * 服务降级
     * @param id
     * @return
     */
    @HystrixCommand( fallbackMethod = "getPaymentByIdTimeout" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    @GetMapping( "/consumer/pm/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = service.create(id);

        return new CommonResult<>(200 , "SUCCESS" , payment);
    }

    /**
     * 全局 降级
     * @param id
     * @return
     */
    @HystrixCommand
    @GetMapping( "/consumer/pm/get2/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable Long id){
        Payment payment = service.create(id);

        return new CommonResult<>(200 , "SUCCESS" , payment);
    }

    public CommonResult<Payment> getPaymentByIdTimeout(@PathVariable Long id){
        return new CommonResult<>(4444 , "FAIL" , null);
    }

    public CommonResult globalsFallBackMethod(){
        return new CommonResult(500 , "ERROR" , null);
    }


}
