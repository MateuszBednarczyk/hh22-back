package com.zse.hh22.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletExceptionHandler {

    @ExceptionHandler(UserAlreadyCreatedWallet.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyCreatedWallet(UserAlreadyCreatedWallet e) {
        return e.getMessage();
    }

}
