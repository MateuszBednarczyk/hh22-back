package com.zse.hh22.security.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface AuthenticationService {
    UsernamePasswordAuthenticationToken createUsernameAuthenticationToken(HttpServletRequest request, HttpServletResponse response);

    Map<Object, Object> successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult);
}
