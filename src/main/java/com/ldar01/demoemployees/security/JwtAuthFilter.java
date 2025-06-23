package com.ldar01.demoemployees.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/**
 * Validate the JWT token and build a valid Authentication instance.
 * This is the class that tells Spring Security: "This user is authenticated with this token."
 */
@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtTokenProvider jwtTokenProvider;
    private CustomUserDetailService customUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Extract the JWT token from the Authorization header of the request
        String token = getTokenFromRequest(request);

        // Validate the token and proceed if it's valid
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // Retrieve the username embedded in the token
            String username = jwtTokenProvider.getUsernameFromToken(token);

            // Load user details from the database or user service
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

            // Create an authentication object with the user's details and authorities
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            // Attach additional details about the request to the authentication object
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Set the authentication object in the SecurityContext for Spring Security
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // Continue the filter chain to process the next filter or the request itself
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        // Get the value of the "Authorization" header from the HTTP request
        String bearerToken = request.getHeader("Authorization");

        // Check if the header is not null and starts with "Bearer "
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            // Return the JWT token by removing the "Bearer " prefix
            return bearerToken.substring(7, bearerToken.length());
        }

        // Return null if a valid token is not found
        return null;
    }
}
