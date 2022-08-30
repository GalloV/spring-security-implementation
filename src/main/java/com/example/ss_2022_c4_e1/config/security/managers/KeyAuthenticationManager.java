package com.example.ss_2022_c4_e1.config.security.managers;

import com.example.ss_2022_c4_e1.config.security.providers.KeyAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

public class KeyAuthenticationManager implements AuthenticationManager {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        KeyAuthenticationProvider keyAuthenticationProvider = new KeyAuthenticationProvider();

        if(keyAuthenticationProvider.supports(authentication.getClass())) {
            return keyAuthenticationProvider.authenticate(authentication);

        }

        return authentication;
    }
}
