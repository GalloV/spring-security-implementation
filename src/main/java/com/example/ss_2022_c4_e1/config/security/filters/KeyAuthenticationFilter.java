package com.example.ss_2022_c4_e1.config.security.filters;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KeyAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1.  create a non authenticated authentication object from our custom keyAuthentication object

        // 2. Call the authentication manager and its method authenticate and pass it our authenticate object

        // 3. get the returned authenticate object

        // 4. if the object in authenticated, pass the request to the next filter. if not ... well we just do something about it


        doFilter(request, response, filterChain);
    }
}
