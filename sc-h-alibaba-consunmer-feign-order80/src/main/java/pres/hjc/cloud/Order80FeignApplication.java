package pres.hjc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 19:37
 */
@SpringBootApplication
@EnableFeignClients
public class Order80FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Order80FeignApplication.class,args);
    }
}
