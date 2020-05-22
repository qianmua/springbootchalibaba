package pres.hjc.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.cloud.entity.CommonResult;
import pres.hjc.cloud.entity.Payment;
import pres.hjc.cloud.handler.CustomerHandler;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/22
 * @time 18:57
 */
@RestController
public class LimitController {

    /**
     * 按照资源名限流
     *
     * 服务挂掉后，控制台规则也就消失了
     *
     * 按照url配置
     *
     * 跟按找资源名一样， 就是  / 的区别
     * @return
     */
    @GetMapping("/resources")
    @SentinelResource( value = "resources" , blockHandler = "fail")
    public CommonResult resources(){
        return new CommonResult(200 , "SUCCESS", new Payment(1000L , "SUCCESS"));
    }

    public CommonResult fail(BlockException b){
        return new CommonResult(500, b.getCause().getMessage() + "\t\t 服务异常");

    }

    /**
     * 自定义全局兜底
     * @return
     */
    @GetMapping("/resource2")
    @SentinelResource( value = "resources" ,
            blockHandlerClass = CustomerHandler.class ,
            blockHandler = "handlerException2")
    public CommonResult resources2(){
        return new CommonResult(200 , "SUCCESS", new Payment(1000L , "SUCCESS"));
    }
}
