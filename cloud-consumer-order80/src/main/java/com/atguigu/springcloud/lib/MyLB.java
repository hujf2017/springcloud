package com.atguigu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hujf
 * @title: MyLB
 * @date 2020/12/14 0014下午 2:33
 * @description: TODO
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >=Integer.MAX_VALUE?0:current+1;
        }while(this.atomicInteger.compareAndSet(current,next));
        System.out.println("next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index =getAndIncrement()%serviceInstances.size();

        return serviceInstances.get(index);
    }
}
