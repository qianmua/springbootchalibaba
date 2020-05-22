package pres.hjc.cloud.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 16:26
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String getZk(){
        return "sc regi with ZK port :" + port + UUID.randomUUID().toString();
    }

    /**
     * docker exec -it zookeeper bash
     * ./zkCli.sh
     * ls / 查看信息
     * */

    /**
     * zk 保存的节点是临时还是永久？ zk 直接干掉，（临时的）
     */
}
