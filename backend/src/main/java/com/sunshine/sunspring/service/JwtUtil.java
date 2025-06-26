package com.sunshine.sunspring.service;

import com.sunshine.sunspring.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtUtil {

    private final String secret = "your-secret-key";

    // Generate JWT using user's email instead of username
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) // Now using email as subject
                .claim("roles", user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Validate token signature and expiration
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    // Extract email (subject) from token
    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // This now returns the email
    }

    // Get full claims from token
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
