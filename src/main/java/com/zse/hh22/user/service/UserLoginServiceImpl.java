package com.zse.hh22.user.service;

import com.zse.hh22.security.configuration.SuffixConfiguration;
import com.zse.hh22.user.api.UserCredentialsDTO;
import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserLoginServiceImpl implements UserLoginService {
    private final UserDetailsServiceImpl userDetailsService;
    private final SuffixConfiguration suffixConfiguration;
    private final UserMapper userMapper;

    @Override
    public UserDTO userLogin(UserCredentialsDTO requestDTO) {
        UserDetails user = userDetailsService.loadUserByUsername(requestDTO.pesel());
        if (!suffixConfiguration.bCryptPasswordEncoder().matches(requestDTO.password(), user.getPassword())) {
            return null;
        }

        return userMapper.mapEntityToDto((UserEntity) user);
    }
}

