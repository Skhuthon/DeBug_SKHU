package org.skhuton.skhudebug.member.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage;

        if(exception instanceof BadCredentialsException) {
            errorMessage = "ID and Password Not Found";
        } else if (exception instanceof UsernameNotFoundException) {
            errorMessage = "User account doesn't exist. sign up, please.";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "Authentication Request is rejected.";
        } else {
            errorMessage = "Unknown Error";
        }

        response.sendError(500, errorMessage);
    }
}
