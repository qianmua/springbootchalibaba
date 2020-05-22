package pres.hjc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/13
 * @time 14:52
 */
@RestController
@RefreshScope
public class ConfigClient3366Controller {



    /**
     * 配置之后需要在发送一次post请求才能刷新配置
     * 使用doc 便可 注意配置文件环境
     * curl -X POST "http://localhost:3355/actuator/refresh"
     */

    @Value("${server.port}")
    private String port;
    @Value("${config.info}")
    private String config;

    @GetMapping("/config")
    public String info(){
        return " info \t" + port + "\t\t" + config;
    }


}
