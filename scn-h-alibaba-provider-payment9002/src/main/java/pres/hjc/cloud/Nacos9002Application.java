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
 * @date 2020/5/17
 * @time 19:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Nacos9002Application {

    public static void main(String[] args) {
        SpringApplication.run(Nacos9002Application.class ,args);
    }
}
