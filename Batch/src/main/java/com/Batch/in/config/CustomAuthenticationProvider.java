package com.Batch.in.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Your supported authentication type
        return true;
    }
}

