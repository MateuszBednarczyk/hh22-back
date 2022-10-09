package com.zse.hh22.user.service;

import com.zse.hh22.security.SuffixConfiguration;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.mapper.UserMapper;
import com.zse.hh22.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;
    private final SuffixConfiguration suffixConfiguration;

    @Override
    public void registerNewUser(UserRegisterDTO requestDTO) {
        checkIfUserAlreadyExists(requestDTO);
        if(!isGivenPasswordNull(requestDTO.password())) {
            UserEntity userEntity = new UserEntity(requestDTO, suffixConfiguration.bCryptPasswordEncoder());
            userRepository.save(userEntity);
        }
    }

    private boolean isGivenPasswordNull(String password) {
        return password.isEmpty();
    }

    private void checkIfUserAlreadyExists(UserRegisterDTO requestDTO) {
        if (userRepository.findByPESEL(requestDTO.PESEL()).isPresent()) {
            throw new IllegalArgumentException("User with this PESEL already exists");
        }
    }
}
