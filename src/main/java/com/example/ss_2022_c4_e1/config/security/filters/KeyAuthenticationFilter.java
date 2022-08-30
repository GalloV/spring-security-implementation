package com.example.ss_2022_c4_e1.config.security.filters;

import com.example.ss_2022_c4_e1.config.security.authentication.KeyAuthentication;
import com.example.ss_2022_c4_e1.config.security.managers.KeyAuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KeyAuthenticationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        KeyAuthenticationManager keyAuthenticationManager = new KeyAuthenticationManager();

        String sentSecret = request.getHeader("secret");


        if(sentSecret == null || "null".equals(sentSecret)) {
            filterChain.doFilter(request, response);
        }

        KeyAuthentication keyAuthentication = new KeyAuthentication(sentSecret);

        var authenticationObject = keyAuthenticationManager.authenticate(keyAuthentication);


        if (authenticationObject.isAuthenticated()) {


            SecurityContextHolder.getContext().setAuthentication(authenticationObject);
            filterChain.doFilter(request, response);


        } else {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }

    }
}
