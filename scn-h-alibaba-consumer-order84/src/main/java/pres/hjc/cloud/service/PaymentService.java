package pres.hjc.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/22
 * @time 20:50
 */
@FeignClient(value = "nacos-payment-provider" , fallback = PaymentFallbackService.class)
public interface PaymentService {

    /**
     * 接口对应 服务提供者 接口
     * @param id
     * @return
     */
    @GetMapping("/payment/{id}")
    CommonResult<Payment> queryById(@PathVariable Long id);


}
