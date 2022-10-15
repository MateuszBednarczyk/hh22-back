package com.zse.hh22.user.service;

import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserInfo(Principal loggedUser) {
        return userMapper.mapEntityToDto((UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName()));
    }
}
