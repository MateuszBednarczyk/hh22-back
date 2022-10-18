package com.zse.hh22.user.service;

import com.zse.hh22.user.api.ChangePasswordDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@Transactional
@RequiredArgsConstructor
class UserManagementServiceImpl implements UserManagementService {

    @Override
    public void changePassword(Principal loggedUser, ChangePasswordDTO requestDTO) {

    }
}
