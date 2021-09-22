package ru.jma.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
                                                            ReactiveClientRegistrationRepository clientRegistrationRepository) {
        return http.authorizeExchange(exchanges ->
                        exchanges.pathMatchers("/actuator/**",
                                        "/users/**", "/courses/**", "/eurekaserver/**")
                                .permitAll()
                                .anyExchange()
                                .authenticated())
                .oauth2Login()
                .and()
                .oauth2Client()
                .and()
                .logout(logout -> logout.logoutSuccessHandler(
                        new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository))
                )
                .headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN)
                .and()
                .csrf().disable()
                .build();
    }
}