package com.ldar01.demoemployees.security;

import com.fasterxml.jackson.databind.DatabindException;
import com.ldar01.demoemployees.entities.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String secret;
    @Value("${app.jwt-expiration-time}")
    private String expirationTime;

    public String generateToken(Authentication auth) {
        String username = auth.getName();
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expirationTime));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getKey())
                .compact();

        return token;

    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );
    }

    //Obtain user from token
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return username;
    }

    //Validate our token
    public boolean validateToken(String token) {
        Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parse(token);
        return true;
    }
}
