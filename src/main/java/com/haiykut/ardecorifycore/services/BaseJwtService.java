package com.haiykut.ardecorifycore.services;
import com.haiykut.ardecorifycore.configurations.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseJwtService {
    private final JwtProperties jwtProperties;

    public BaseJwtService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }
    public String generateToken(String username, Map<String, Object> extraClaims)
    {
        String token = Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .claims(extraClaims)
                .signWith(getSigningKey())
                .compact();
        return token;
    }

    public String getSECRET_KEY(){
        return jwtProperties.getSecretKey();
    }
    public String generateTokenWithClaims(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        List<String> roles = userDetails
                .getAuthorities()
                .stream()
                .map((role) -> role.getAuthority())
                .toList();
        claims.put("roles", roles);
        return generateToken(userDetails.getUsername(), claims);
    }

    public Boolean validateToken(String token)
    {
        return getTokenClaims(token).getExpiration().after(new Date()); // Kendi ürettiğim token mı?
    }
    public String extractUsername(String token)
    {
        return getTokenClaims(token).getSubject();
    }

    public List<String> extractRoles(String token)
    {
        return getTokenClaims(token).get("roles", List.class);
    }

    private Claims getTokenClaims(String token)
    {
        return Jwts
                .parser()
                .verifyWith((SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSigningKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
