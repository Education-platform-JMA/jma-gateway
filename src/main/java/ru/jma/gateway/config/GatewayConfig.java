package ru.jma.gateway.config;

import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder, TokenRelayGatewayFilterFactory tokenFilterFactory) {
        return builder.routes()
                .route("eureka_server_route",
                        route -> route.path("/eurekaserver/**")
                                .filters(filter -> filter.stripPrefix(1).filter(tokenFilterFactory.apply()))
                                .uri("lb://eurekaserver"))
                .route("users_route",
                        route -> route.path("/users/**")
                                .filters(filter -> filter.stripPrefix(1).filter(tokenFilterFactory.apply()))
                                .uri("lb://users"))
                .route("courses_route",
                        route -> route.path("/courses/**")
                                .filters(filter -> filter.stripPrefix(1).filter(tokenFilterFactory.apply()))
                                .uri("lb://courses"))
                .build();
    }
}
