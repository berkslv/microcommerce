package com.microcommerce.product.security;


import com.microcommerce.product.security.CustomAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private String MANAGER = "MANAGER";
    private String CUSTOMER = "CUSTOMER";


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/product-api/products/**").hasAnyAuthority(MANAGER, CUSTOMER)
                .requestMatchers("/product-api/brands/**").hasAnyAuthority(MANAGER, CUSTOMER)
                .requestMatchers("/product-api/categories/**").hasAnyAuthority(MANAGER, CUSTOMER);

        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
