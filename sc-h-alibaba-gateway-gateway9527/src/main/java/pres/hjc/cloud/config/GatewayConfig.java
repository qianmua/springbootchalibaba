package pres.hjc.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/12
 * @time 19:27
 */
@Configuration
public class GatewayConfig {

    /**
     * 路由定位器
     * @param builder 构建器
     * @return
     */
    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();


        /**
         * 新的路由规则
         */
        routes.route("gateway_route_1" ,
                r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return routes.build();


    }
}
