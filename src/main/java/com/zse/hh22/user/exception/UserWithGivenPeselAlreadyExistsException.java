package com.zse.hh22.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.zse.hh22.user.exception.UserExceptionsFinals.USER_WITH_GIVEN_PESEL_ALREADY_EXISTS;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserWithGivenPeselAlreadyExistsException extends IllegalArgumentException {

    public UserWithGivenPeselAlreadyExistsException() {
        super(USER_WITH_GIVEN_PESEL_ALREADY_EXISTS);
    }
}
