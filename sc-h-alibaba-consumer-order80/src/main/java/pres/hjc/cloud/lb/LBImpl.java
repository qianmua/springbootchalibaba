package pres.hjc.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/11
 * @time 18:40
 */
@Component
public class LBImpl implements LoadBalancer {

    /**
     * 原子Integer
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自旋算法
     * @return
     */
    public final int getAndInstance(){
        int current;
        int next;

        //自旋
        do {
            current = this.atomicInteger.get();
            //越界
            next = current >= 0x7fffffff ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current , next));
        return next;
    }

    /**
     * 选举
     * @param serviceInstances int
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int i = getAndInstance() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
