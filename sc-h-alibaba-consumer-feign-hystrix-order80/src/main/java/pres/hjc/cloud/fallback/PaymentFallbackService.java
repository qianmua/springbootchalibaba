package pres.hjc.cloud.fallback;

import org.springframework.stereotype.Component;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.service.PaymentHystrixService;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/12
 * @time 16:12
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public Payment create(Long id) {
        return new Payment(0L , "/(ㄒoㄒ)/~~ /(ㄒoㄒ)/~~ /(ㄒoㄒ)/~~" );
    }
}
