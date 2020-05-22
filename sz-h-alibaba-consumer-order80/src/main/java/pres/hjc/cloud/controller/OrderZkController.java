package pres.hjc.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 17:19
 */
@RestController
@Slf4j
public class OrderZkController {

    private static String PATH = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/cons/zk")
    public String paymentInfo(){
        String res = restTemplate.getForObject(PATH + "/payment/zk" , String.class);
        return res;
    }

}
