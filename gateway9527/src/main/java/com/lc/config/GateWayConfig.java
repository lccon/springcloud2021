package com.lc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

}
