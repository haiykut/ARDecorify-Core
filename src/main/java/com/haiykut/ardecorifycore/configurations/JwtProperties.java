package com.haiykut.ardecorifycore.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String secretKey;
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
