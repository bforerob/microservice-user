package com.user.microservice.configuration.security;


import com.user.microservice.configuration.security.jwtconfiguration.JwtAuthenticationFilter;
import com.user.microservice.domain.util.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeRequests ->{
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/category/").hasAuthority(Permission.ADD_CATEGORY.name());
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/brand/").hasAuthority(Permission.ADD_BRAND.name());
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/article/").hasAuthority(Permission.ADD_ARTICLE.name());
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/auth/register/aux").hasAuthority(Permission.REGISTER_AUX.name());
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/auth/register/customer").permitAll();
                    authorizeRequests.requestMatchers(HttpMethod.POST, "/supply/").hasAuthority(Permission.ADD_SUPPLY.name())

                            .anyRequest().authenticated();

                });

        return http.build();
    }


}