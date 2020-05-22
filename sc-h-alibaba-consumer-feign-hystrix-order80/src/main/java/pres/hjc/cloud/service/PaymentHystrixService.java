package pres.hjc.cloud.service;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.fallback.PaymentFallbackService;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 20:48
 */
@Component
// 解耦全局降级
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" , fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    /**
     * feign
     * @param id
     * @return
     */
    @GetMapping( "/payment/get/{id}")
    Payment create(@PathVariable("id") Long id);
}
