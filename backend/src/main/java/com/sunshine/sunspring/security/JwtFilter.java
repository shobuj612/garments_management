package com.sunshine.sunspring.security;

import com.sunshine.sunspring.service.JwtUtil;
import com.sunshine.sunspring.model.User;
import com.sunshine.sunspring.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        // Get the 'Authorization' header
        final String authHeader = request.getHeader("Authorization");

        // If there is a Bearer token in the header
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token by removing "Bearer " prefix
            String token = authHeader.substring(7);

            // If the token is valid
            if (jwtUtil.validateToken(token)) {
                // Extract the email from the token
                String email = jwtUtil.getEmailFromToken(token);

                // Fetch the user by email from the database
                User user = userRepository.findByEmail(email);

                if (user != null) {
                    // Create an authentication token with user email and roles
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            user.getEmail(), null,  // Use email as username for authentication
                            user.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName().name()))  // Convert roles to authorities
                                .collect(Collectors.toList())
                    );

                    // Set the authentication context with the token
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        // Continue the filter chain
        chain.doFilter(request, response);
    }
}
