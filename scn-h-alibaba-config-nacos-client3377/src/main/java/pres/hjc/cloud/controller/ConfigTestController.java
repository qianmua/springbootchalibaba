package pres.hjc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/17
 * @time 20:19
 */
@RestController
// 支持 nacos 动态刷新
@RefreshScope
public class ConfigTestController {

    @Value("${server.port}")
    private String prot;

    @Value("${config.info}")
    private String info;

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id){
        return prot + id ;
    }
    @GetMapping("/config/info")
    public String info(){
        return info;
    }
}
