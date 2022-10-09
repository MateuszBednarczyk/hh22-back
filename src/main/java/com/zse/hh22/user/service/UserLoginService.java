package com.zse.hh22.user.service;

import com.zse.hh22.user.api.UserCredentialsDTO;
import com.zse.hh22.user.api.UserDTO;

public interface UserLoginService {
    UserDTO userLogin(UserCredentialsDTO requestDTO);
}
