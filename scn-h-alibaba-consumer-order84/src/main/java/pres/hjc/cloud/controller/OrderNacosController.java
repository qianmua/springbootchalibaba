package pres.hjc.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/17
 * @time 19:37
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String url;

    public static final String SERVER_URL = "http://nacos-payment-provider";


    @GetMapping("/cons/get/{id}")
    public String get(@PathVariable String id){
        return restTemplate.getForObject(url + "/get/" + id ,  String.class);
    }


    /**
     * 配置 熔断
     *
     * 配置 错误
     * @param id
     * @return
     */
    @GetMapping("/cons/fall/{id}")
    @SentinelResource( value = "fall" , fallback = "handlerFull")
    public CommonResult fall(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/get/" + id, CommonResult.class, id);

        return result;
    }

    /**
     * 配置 限流
     *
     * 配置 违规 sentinel 限流规则
     * @param id
     * @return
     */
    @GetMapping("/cons/fall2/{id}")
    @SentinelResource( value = "fall2" , blockHandler = "handlerBlock")
    public CommonResult fall2(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/get/" + id, CommonResult.class, id);
        return result;
    }

    /**
     * 限流 熔断 双开
     * @param id
     * @return
     */
    @GetMapping("/cons/fall3/{id}")
    @SentinelResource( value = "fall2" ,
            blockHandler = "handlerBlock" ,
            fallback = "handlerFull" ,
            /*将这个异常排除出去 就是说不是所有的 异常都 应该处理  演示用空指针*/
            exceptionsToIgnore = {NullPointerException.class} )
    public CommonResult fall3(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/get/" + id, CommonResult.class, id);
        return result;
    }

    /**
     * full back
     * 服务熔断
     * @param id
     * @param throwable
     * @return
     */
    public CommonResult handlerFull(@PathVariable Long id , Throwable throwable){
        Payment payment = new Payment(id, null);
        return new CommonResult(501 , "服务熔断兜底" + throwable.getCause().getMessage() ,payment);
    }

    /**
     * 服务限流
     * @param id
     * @param throwable
     * @return
     */
    public CommonResult handlerBlock(@PathVariable Long id , BlockException throwable){
        Payment payment = new Payment(id, null);
        return new CommonResult(502 , "服务熔断兜底" + throwable.getCause().getMessage() ,payment);
    }






}
