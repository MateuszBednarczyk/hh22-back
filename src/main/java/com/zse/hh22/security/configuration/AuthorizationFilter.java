package com.zse.hh22.security.configuration;

import com.zse.hh22.security.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
class AuthorizationFilter extends OncePerRequestFilter {

    private final AuthorizationService authorizationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/user/login") || request.getServletPath().equals("/api/user/refreshToken")) {
            filterChain.doFilter(request, response);
        } else {
            if (request.getHeader(AUTHORIZATION) != null) {
                authorizationService.tryAuthorize(request, response, filterChain);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
