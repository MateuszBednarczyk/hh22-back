package com.zse.hh22.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.zse.hh22.user.exception.UserExceptionsFinals.GIVEN_OLD_PASSWORD_IS_NOT_CORRECT_OR_OLD_PASSWORD_REPEATING_IS_NOT_CORRECT;

@ResponseStatus(HttpStatus.CONFLICT)
public class GivenOldPasswordIsNotCorrectOrOldPasswordRepeatingIsNotCorrectException extends IllegalArgumentException {
    public GivenOldPasswordIsNotCorrectOrOldPasswordRepeatingIsNotCorrectException() {
        super(GIVEN_OLD_PASSWORD_IS_NOT_CORRECT_OR_OLD_PASSWORD_REPEATING_IS_NOT_CORRECT);
    }
}
