package com.zse.hh22.civicproject.service;

import java.security.Principal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.civicproject.exception.UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeCivicProjectServiceImpl implements LikeCivicProjectService {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final FindCivicProjectService civicProjectFindService;

    @Override
    public void likeCivicProject(Principal loggedUser, String title) {
        UserEntity userEntity = (UserEntity) userDetailsServiceImpl.loadUserByUsername(loggedUser.getName());
        CivicProjectEntity civicProjectEntity = civicProjectFindService.findCivicProjectEntityByTitle(title);
        if (isUserLikedCivicProjectNull(userEntity)
                && isUserCityAndCivicProjectCityEquals(userEntity.getCity(), civicProjectEntity.getCity())) {
            userEntity.setLikedCivicProject(civicProjectEntity);
            civicProjectEntity.getLikedBy().add(userEntity);
        } else {
            throw new UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject();
        }
    }

    private boolean isUserLikedCivicProjectNull(UserEntity userEntity) {
        return userEntity.getLikedCivicProject() == null;
    }

    private boolean isUserCityAndCivicProjectCityEquals(String userCity, String civicProjectCity) {
        return userCity.equals(civicProjectCity);
    }
}
