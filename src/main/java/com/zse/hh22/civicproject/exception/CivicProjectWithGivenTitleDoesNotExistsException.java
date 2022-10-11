package com.zse.hh22.civicproject.exception;

import static com.zse.hh22.civicproject.exception.CivicProjectExceptionsFinals.CIVIC_PROJECT_WITH_GIVEN_TITLE_DOES_NOT_EXIST;

public class CivicProjectWithGivenTitleDoesNotExistsException extends IllegalArgumentException {
    CivicProjectWithGivenTitleDoesNotExistsException(){
        super(CIVIC_PROJECT_WITH_GIVEN_TITLE_DOES_NOT_EXIST);
    }
}
