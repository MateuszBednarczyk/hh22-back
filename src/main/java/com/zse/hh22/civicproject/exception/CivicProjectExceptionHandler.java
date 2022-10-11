package com.zse.hh22.civicproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CivicProjectExceptionHandler {

    @ExceptionHandler(CivicProjectWithGivenTitleAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCivicProjectWithGivenTitleAlreadyExistsException(CivicProjectWithGivenTitleAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(CivicProjectWithGivenTitleDoesNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCivicProjectWithGivenTitleDoesNotExistsException(CivicProjectWithGivenTitleDoesNotExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUserCityIsNotEqualsToCivicProjectCityException(UserCityIsNotEqualsToCivicProjectCityOrUserHasAlreadyLikedOtherCivicProject e) {
        return e.getMessage();
    }

}
