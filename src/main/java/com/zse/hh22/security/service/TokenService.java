package com.zse.hh22.security.service;

import com.zse.hh22.user.domain.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface TokenService {
    String generateAccessToken(UserEntity user, String issuer);

    String generateRefreshToken(UserEntity user, String issuer);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
