package com.gonzalo.bikeapi.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.gonzalo.bikeapi.exception.UserNotFoundException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (UserNotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } 
        catch (RuntimeException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
