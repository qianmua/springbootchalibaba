package pres.hjc.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/12
 * @time 20:30
 */
@Component
@Slf4j
public class GlobalGatewayFilter implements GlobalFilter, Ordered {

    /**
     * gateway 网关 过滤
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=========log=========filter -> " + System.currentTimeMillis());
        //规则
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)){
            log.info(" ==========参数不匹配 403==========");
            //403
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            //返回响应信息
            return exchange.getResponse().setComplete();
        }
        //过滤链
        return chain.filter(exchange);

    }

    /**
     * 加载过滤器顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
