package com.zse.hh22.civicproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.zse.hh22.civicproject.exception.CivicProjectExceptionsFinals.CIVIC_PROJECT_WITH_GIVEN_TITLE_ALREADY_EXISTS;

@ResponseStatus(HttpStatus.CONFLICT)
public class CivicProjectWithGivenTitleAlreadyExistsException extends IllegalArgumentException {

    public CivicProjectWithGivenTitleAlreadyExistsException() {
        super(CIVIC_PROJECT_WITH_GIVEN_TITLE_ALREADY_EXISTS);
    }
}
