package pres.hjc.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.mapper.PaymentMapper;
import pres.hjc.cloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/10
 * @time 19:03
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @HystrixCommand( fallbackMethod = "getPaymentByIdTimeout" , commandProperties = {
            // 超时
            @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public List<Payment> queryAll() {
        return paymentMapper.queryAll();
    }

    public Payment getPaymentByIdTimeout(Long id){
        return new Payment(id,"this id is error");
    }


    /**
     * 服务熔断
     */
    @HystrixCommand( fallbackMethod = "paymentCircuitBreakerFallBack" , commandProperties = {
            // 是否开启断路器 开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            // 请求次数 失败次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            // 时间窗口期 半开状态 时间内的状态
            // 如果半开状态 有响应成功了，那么就 关闭断路器，回复使用 ，继续 主逻辑
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 失败率达到多少后跳闸 10 / 30
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "30")
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable Long id){
        if (id < 0){
            throw new RuntimeException("---------id --------is ----------小于零----");

        }
        String ss = IdUtil.simpleUUID();
        return "success" + ss;
    }

    public String paymentCircuitBreakerFallBack(@PathVariable Long id){
        return " FALI \t" + id + "\t" + IdUtil.simpleUUID();
    }

}
