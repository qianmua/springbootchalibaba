package pres.hjc.cloud.service;

import org.apache.ibatis.annotations.Param;
import pres.hjc.cloud.entity.Payment;

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
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    List<Payment> queryAll();

    public String paymentCircuitBreaker(Long id);

}
