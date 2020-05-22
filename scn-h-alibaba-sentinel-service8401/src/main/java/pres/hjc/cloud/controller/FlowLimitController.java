package pres.hjc.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/19
 * @time 18:22
 */
@RestController
public class FlowLimitController {

    /*
    * 流控模式
    * 单机/线程阈值 模式 流控效果
    *
    *
    * 接口
    * 模式
    * 直接 api阈值直接限流
    * 关联 关联资源阈值自己限流
    * 链路  记录指定链路资源 阈值 则限流
    *
    * 流控效果
    * 直接 error
    * 预热 初始阈/3 然后在预热时间之后达到阈值 慢慢达到阈值
    * 排队 队列排队
    *
    *
    * 服务降级规则
    * RT 平均响应时间 s 在 ms以内响应 响应时间
    * 超出阈值 且 时间窗口其内 请求大于5 满足 触发降级
    * 窗口期过后关闭降级
    *   rt MAX <= 4900
    *
    * 异常比例 秒 异常数
    * qps 》=5 且 异常比例 大于 阈值 降级
    *
    * 异常数 分钟
    * 异常数（按分钟统计） 超过阈值 降级
    *
    * 异常500 是你的  熔断降级 是sentinel
    *
    *
    * 热点规则
    *
    *
    *
    *
    *
    *
    * */

    @GetMapping("/test1")
    public String test1(){
        return "-----test1";
    }
    @GetMapping("/test2")
    public String test2(){
        return "-----test2";
    }
}
