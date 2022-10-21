package com.zse.hh22.user.service;

import com.zse.hh22.user.api.UserDTO;

import java.security.Principal;

public interface UserInfoService {
    UserDTO getUserInfo(Principal loggedUser);
}
