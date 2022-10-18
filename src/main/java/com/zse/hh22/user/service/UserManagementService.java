package com.zse.hh22.user.service;

import com.zse.hh22.user.api.ChangePasswordDTO;

import java.security.Principal;

public interface UserManagementService {

    void changePassword(Principal loggedUser, ChangePasswordDTO requestDTO);

}
