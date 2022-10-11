package com.zse.hh22.civicproject.exception;

import static com.zse.hh22.civicproject.exception.CivicProjectExceptionsFinals.CIVIC_PROJECT_WITH_GIVEN_TITLE_DOES_NOT_EXIST;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CivicProjectWithGivenTitleDoesNotExistsException extends IllegalArgumentException {
    public CivicProjectWithGivenTitleDoesNotExistsException() {
        super(CIVIC_PROJECT_WITH_GIVEN_TITLE_DOES_NOT_EXIST);
    }
}
