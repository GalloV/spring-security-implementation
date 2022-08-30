package com.example.ss_2022_c4_e1.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityWebConfig  {

    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        return  http
                .httpBasic().and()
                .build();
    }

}
