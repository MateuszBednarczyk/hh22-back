package com.zse.hh22.user.service;

import com.zse.hh22.user.api.UserRegisterDTO;

public interface UserRegisterService {
    void registerNewUser(UserRegisterDTO requestDTO);
}
