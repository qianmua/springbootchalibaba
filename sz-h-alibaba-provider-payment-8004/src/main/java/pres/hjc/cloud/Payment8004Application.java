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
 * @time 16:21
 */
@SpringBootApplication
/**向 zk 或者consul注册*/
@EnableDiscoveryClient
public class Payment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8004Application.class,args);
    }
}
