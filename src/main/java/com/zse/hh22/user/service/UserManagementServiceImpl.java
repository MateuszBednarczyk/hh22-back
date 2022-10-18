package com.zse.hh22.user.service;

import com.zse.hh22.security.configuration.SuffixConfiguration;
import com.zse.hh22.user.api.ChangePasswordDTO;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.exception.GivenOldPasswordIsNotCorrectOrOldPasswordRepeatingIsNotCorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@Transactional
@RequiredArgsConstructor
class UserManagementServiceImpl implements UserManagementService {

    private final UserDetailsServiceImpl userDetailsService;
    private final SuffixConfiguration suffixConfiguration;

    @Override
    public void changePassword(Principal loggedUser, ChangePasswordDTO requestDTO) {
        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
        if (isGivenOldPasswordCorrect(requestDTO, user) && isNewPasswordRepeatingMatchesNewPassword(requestDTO)) {
            user.setPassword(encodePassword(requestDTO));
        } else {
            throw new GivenOldPasswordIsNotCorrectOrOldPasswordRepeatingIsNotCorrectException();
        }
    }

    private String encodePassword(ChangePasswordDTO requestDTO) {
        return suffixConfiguration.bCryptPasswordEncoder().encode(requestDTO.newPassword());
    }

    private boolean isNewPasswordRepeatingMatchesNewPassword(ChangePasswordDTO requestDTO) {
        return requestDTO.repeatNewPassword().matches(requestDTO.newPassword());
    }

    private boolean isGivenOldPasswordCorrect(ChangePasswordDTO requestDTO, UserEntity user) {
        return suffixConfiguration.bCryptPasswordEncoder().matches(requestDTO.oldPassword(), user.getPassword());
    }
}
