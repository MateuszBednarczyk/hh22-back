package com.zse.hh22.user.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.zse.hh22.security.configuration.SuffixConfiguration;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.domain.Role;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.exception.UserWithGivenPeselAlreadyExistsException;
import com.zse.hh22.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;
    private final SuffixConfiguration suffixConfiguration;

    @Override
    public void registerNewUser(@Valid UserRegisterDTO requestDTO) {
        createAndSaveUser(requestDTO, Role.ROLE_USER);
    }

    @Override
    public void registerNewAdmin(UserRegisterDTO requestDTO) {
        createAndSaveUser(requestDTO, Role.ROLE_ADMIN);
    }

    private void createAndSaveUser(UserRegisterDTO requestDTO, Role role) {
        checkIfUserAlreadyExists(requestDTO);
        if (!isGivenPasswordNull(requestDTO.password())) {
            UserEntity userEntity = new UserEntity(requestDTO, suffixConfiguration.bCryptPasswordEncoder(), role);
            userRepository.save(userEntity);
        }
    }

    private boolean isGivenPasswordNull(String password) {
        return password.isEmpty();
    }

    private void checkIfUserAlreadyExists(UserRegisterDTO requestDTO) {
        if (userRepository.findByPesel(requestDTO.pesel()).isPresent()) {
            throw new UserWithGivenPeselAlreadyExistsException();
        }
    }

}
