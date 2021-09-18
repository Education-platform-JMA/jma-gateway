package ru.jma.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .oauth2Login(withDefaults())
                .oauth2ResourceServer(rs -> rs.jwt(withDefaults()));
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public ReactiveJwtDecoder reactiveJwtDecoder(@Value("${spring.security.oauth2.client.provider.keycloak.jwk-set-uri}") String uri) {
        return new NimbusReactiveJwtDecoder(uri);
    }
}