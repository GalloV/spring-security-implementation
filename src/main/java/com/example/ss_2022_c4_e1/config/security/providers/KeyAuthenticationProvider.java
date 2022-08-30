package com.example.ss_2022_c4_e1.config.security.providers;

import com.example.ss_2022_c4_e1.config.security.authentication.KeyAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class KeyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        KeyAuthentication keyAuthentication = (KeyAuthentication) authentication;

        System.out.println("We are here");

        String secret = "omg_this";

        if(keyAuthentication.getSecret().equals(secret)) {
            keyAuthentication.setAuthenticated(true);
            return keyAuthentication;
        }

        throw new BadCredentialsException("Sorry baby ! just go get the secret...");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return KeyAuthentication.class.equals(authentication);
    }
}
