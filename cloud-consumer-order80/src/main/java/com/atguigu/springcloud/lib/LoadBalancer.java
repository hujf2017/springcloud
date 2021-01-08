package com.atguigu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Hujf
 * @title: LoadBalancer
 * @date 2020/12/14 0014下午 2:31
 * @description: TODO
 */
public interface LoadBalancer {

     ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
