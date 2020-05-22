package pres.hjc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/13
 * @time 14:51
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366Application.class , args);
    }


}
