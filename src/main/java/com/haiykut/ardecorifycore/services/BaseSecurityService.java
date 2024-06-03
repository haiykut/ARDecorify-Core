package com.haiykut.ardecorifycore.services;

import com.haiykut.ardecorifycore.security.BaseJwtFilter;
import org.springframework.stereotype.Service;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Service
public class BaseSecurityService {
    private final BaseJwtFilter jwtFilter;
    public BaseSecurityService(BaseJwtFilter jwtFilter){
        this.jwtFilter = jwtFilter;
    }

    public void configureCoreSecurity(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
