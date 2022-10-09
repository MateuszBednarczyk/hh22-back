package com.zse.hh22.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.zse.hh22.security.service.SecurityFinals.TOKEN_EXPIRATION_TIME;
import static com.zse.hh22.security.service.SecurityFinals.TOKEN_PREFIX;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@RequiredArgsConstructor
class TokenServiceImpl implements TokenService {
    private final UserDetailsServiceImpl userDetailsService;

    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

    public String generateAccessToken(UserEntity user, String issuer) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String generateRefreshToken(UserEntity user, String issuer) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME * 2))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oldRefreshToken = request.getHeader(AUTHORIZATION).substring(TOKEN_PREFIX.length());
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(oldRefreshToken);
            String PESEL = decodedJWT.getSubject();
            UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(PESEL);
            String accessToken = generateAccessToken(user, request.getRequestURI());
            String newRefreshToken = generateRefreshToken(user, request.getRequestURI());
            Map<String, String> tokens = new HashMap<>();
            tokens.put("access_token", accessToken);
            tokens.put("refresh_token", newRefreshToken);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), tokens);
        } catch (Exception e) {
            throw e;
        }
    }
}
