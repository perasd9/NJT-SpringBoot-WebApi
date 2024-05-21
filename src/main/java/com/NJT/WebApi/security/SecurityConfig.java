package com.NJT.WebApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    JWTRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(JWTRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/sala").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/tipsale").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/statussale").hasAuthority("ADMIN")
                .anyRequest().authenticated());
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
