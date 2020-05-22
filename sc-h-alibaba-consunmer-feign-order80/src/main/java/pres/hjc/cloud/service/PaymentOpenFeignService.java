package pres.hjc.cloud.service;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 19:41
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentOpenFeignService {

    /**
     * feign 调用接口
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
