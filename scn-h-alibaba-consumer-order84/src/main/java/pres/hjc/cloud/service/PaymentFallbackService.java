package pres.hjc.cloud.service;


import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/22
 * @time 20:53
 */
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> queryById(Long id) {
        return new CommonResult<>(501 , "服务降级 feign service" , new Payment(id , "error"));
    }
}
