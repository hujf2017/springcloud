package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hujf
 * @title: GateWayConfig
 * @date 2021/1/9 0009下午 8:17
 * @description: TODO
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes= routeLocatorBuilder.routes();
        routes.route("path_route_at",r->r.path("/pay/lb2").uri("http://localhost:8001/pay/lb2")).build();
        return routes.build();
    }
}
