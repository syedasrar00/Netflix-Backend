package com.netflix.backend.configurations;

import org.springframework.boot.web.server.Cookie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CookieConfiguration {
    @Bean
    public Cookie cookie(){
        return new Cookie();
    }
}
