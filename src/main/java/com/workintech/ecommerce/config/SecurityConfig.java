package com.workintech.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(auth -> {
            auth.requestMatchers(HttpMethod.POST, "/users/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/users/{id}/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/users").hasAnyAuthority("admin");
            auth.requestMatchers("/address/**").hasAnyAuthority("user", "store");
            auth.requestMatchers("/card/**").hasAnyAuthority("user", "store");
            auth.requestMatchers(HttpMethod.POST, "/category/**").hasAnyAuthority("admin");
            auth.requestMatchers(HttpMethod.GET, "/category/**").permitAll();
            auth.requestMatchers("/order/**").hasAnyAuthority("user", "store");
            auth.requestMatchers(HttpMethod.GET, "/products/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/products/save/**").hasAnyAuthority("store");
            auth.requestMatchers(HttpMethod.GET, "/roles/**").permitAll();
            auth.anyRequest().authenticated();

        }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();
    }

}
