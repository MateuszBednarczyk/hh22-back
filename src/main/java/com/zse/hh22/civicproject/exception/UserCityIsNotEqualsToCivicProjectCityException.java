package com.zse.hh22.civicproject.exception;

import static com.zse.hh22.civicproject.exception.CivicProjectExceptionsFinals.USER_CITY_IS_NOT_EQUALS_TO_CIVIC_PROJECT_CITY;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserCityIsNotEqualsToCivicProjectCityException extends IllegalArgumentException{
    public UserCityIsNotEqualsToCivicProjectCityException(String name, String surname){
        super(USER_CITY_IS_NOT_EQUALS_TO_CIVIC_PROJECT_CITY + ": " + name + " " + surname);
    }       
}
