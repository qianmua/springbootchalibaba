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
 * @date 2020/5/22
 * @time 19:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer84Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer84Application.class , args);
    }
}
