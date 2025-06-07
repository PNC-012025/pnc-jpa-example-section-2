package com.ldar01.demoemployees.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 This class is responsible for handling authentication errors.
 For example, when a user tries to access a resource without a valid token, this is triggered. */
@Component
public class JwtAuth implements AuthenticationEntryPoint {

    //This method sends an HTTP 401 (Unauthorized) error when an authentication exception occurs,
    //indicating that the user is not authenticated or the provided token is invalid.
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
