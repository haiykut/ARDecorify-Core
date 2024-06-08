package com.haiykut.ardecorifycore.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private Long expiration;
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey, Long expiration){
        this.secretKey = secretKey;
    }

    public Long getExpiration() {
        return expiration;
    }
    public void setExpiration(Long expiration){
        this.expiration = expiration;
    }
}
