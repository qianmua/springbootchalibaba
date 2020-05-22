package pres.hjc.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/10
 * @time 19:31
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PATH = "http://localhost:8001";
    /**对外暴漏微服务名*/
    private static final String PATH2 = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalancer loadBalancer;

    /**
     * 发现注册机注册信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pm/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PATH + "/payment/create" ,payment, CommonResult.class );
    }


    @GetMapping("/consumer/pm/get/{id}")
    public CommonResult getPayment(@PathVariable( "id") Long id){
        log.info("consumer");
        return restTemplate.getForObject(PATH + "/payment/get/" + id, CommonResult.class );
    }

    @GetMapping("/consumer/pme/get/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PATH + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444 , "fail");
        }

    }

    @GetMapping("/consumer/dis")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        //得到改服务下模块信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        System.out.println(instances);
        instances.forEach(i -> {
            System.out.println(i.getInstanceId());
            System.out.println(i.getHost());
            System.out.println(i.getPort());
            System.out.println(i.getServiceId());
        });
        return services;
    }

    /**
     * 自定义轮询算法
     * @return
     */
    @GetMapping("/consumer/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if ( instances == null || instances.size() == 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject( uri + "payment/get/lb" , String.class);
    }

}
