package com.zse.hh22.civicproject.service;

import java.security.Principal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.civicproject.repository.CivicProjectRepository;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeCivicProjectServiceImpl implements LikeCivicProjectService {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final CivicProjectRepository civicProjectRepository;

    @Override
    public void likeCivicProject(Principal loggedUser, String title) {
        UserEntity userEntity = (UserEntity) userDetailsServiceImpl.loadUserByUsername(loggedUser.getName());
        CivicProjectEntity civicProjectEntity = civicProjectRepository.findByTitle(title).orElseThrow();
        if(userEntity.getLikedCivicProject() == null){
            userEntity.setLikedCivicProject(civicProjectEntity);
            civicProjectEntity.getLikedBy().add(userEntity);
        }
    }
}
