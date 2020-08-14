package com.changgou.security.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenRequestIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {


        String token = "Bearer "+"";
        requestTemplate.header("Authorization",token);
    }
}
