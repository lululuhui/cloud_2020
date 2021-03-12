package com.luhuihahah.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     * 跳转到百度新闻   http://localhost:9527/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_rout",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }


}
