package pres.hjc.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import pres.hjc.cloud.entity.CommonResult;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/22
 * @time 19:07
 */
public class CustomerHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(501 , "自定义handler 处理代码膨胀-1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(502 , "自定义handler 处理代码膨胀-2");
    }
}
