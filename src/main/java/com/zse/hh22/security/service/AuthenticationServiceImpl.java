package com.zse.hh22.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenServiceImpl tokenServiceImpl;
    private final UserMapper userMapper;

    public UsernamePasswordAuthenticationToken createUsernameAuthenticationToken(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String> requestMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            String pesel = requestMap.get("pesel");
            String password = requestMap.get("password");
            return new UsernamePasswordAuthenticationToken(pesel, password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Object, Object> successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
        UserEntity user = (UserEntity) authResult.getPrincipal();
        String issuer = request.getRequestURI();
        String accessToken = tokenServiceImpl.generateAccessToken(user, issuer);
        String refreshToken = tokenServiceImpl.generateRefreshToken(user, issuer);
        Map<Object, Object> responseBody = new HashMap<>();
        responseBody.put("access_token", accessToken);
        responseBody.put("refresh_token", refreshToken);
        responseBody.put("user", userMapper.mapEntityToDto(user));

        return responseBody;
    }
}
