package com.zse.hh22.civicproject.exception;

import static com.zse.hh22.civicproject.exception.CivicProjectExceptionsFinals.USER_CITY_IS_NOT_EQUALS_TO_CIVIC_PROJECT_CITY_OR_USER_HAS_ALREADY_LIKED_OTHER_CIVIC_PROJECT;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject extends IllegalArgumentException {
    public UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject(){
        super(USER_CITY_IS_NOT_EQUALS_TO_CIVIC_PROJECT_CITY_OR_USER_HAS_ALREADY_LIKED_OTHER_CIVIC_PROJECT);
    }
}
