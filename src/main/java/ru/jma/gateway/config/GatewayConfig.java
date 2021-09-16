package ru.jma.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("eureka_server_route",
                        route -> route.path("/eurekaserver/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://eurekaserver"))
                .route("users_route",
                        route -> route.path("/users/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://users"))
                .route("courses_route",
                        route -> route.path("/courses/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://courses"))
                .build();
    }
}
