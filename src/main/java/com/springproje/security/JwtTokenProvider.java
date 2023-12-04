package com.springproje.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.net.Authenticator;

@Component
public class JwtTokenProvider {
   @Value("${springproje.app.secret}")
    private String APP_SECRET;
    @Value("${springproje.expires.in}")
    private Long EXPIRES_IN;


