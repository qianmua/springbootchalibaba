package pres.hjc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/13
 * @time 13:14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication {

    /**
     * 总线通知
     * curl -X POST "http://localhost:3344/actuator/bus-refresh"
     * 单点通知
     * curl -X POST "http://localhost:3344/actuator/bus-refresh/{@服务名}:{@端口号}"
     * */
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication.class,args);
    }
}
