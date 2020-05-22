package pres.hjc.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 18:16
 */
@Configuration
public class MyRule {
    /**
     * 负载均衡算法
     *
     * 轮询
     * rest接口请求数 % 集群数量 = 实际调用服务器位置下标 重启服务器后rest计数由1开始
     */

    /**
     * ribbon 负载均衡规则
     * 不可以跟启动类放在一块，会被所有的ribbon客户端共享
     * 想自己使用，就跳出这个包
     * @return
     */
    @Bean
    public IRule rule(){
        //随机
        return new RandomRule();
    }
}
