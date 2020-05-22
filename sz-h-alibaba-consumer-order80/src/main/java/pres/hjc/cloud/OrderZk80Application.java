package pres.hjc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 17:14
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZk80Application {

    /**
     * CAP 原则
     * 一致性
     * 可用性
     * 容错性
     * CP
     * AP
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80Application.class ,args);
    }
}
