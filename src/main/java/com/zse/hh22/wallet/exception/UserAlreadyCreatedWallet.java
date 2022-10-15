package com.zse.hh22.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.zse.hh22.wallet.exception.WalletExceptionsFinals.USER_ALREADY_CREATED_WALLET;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyCreatedWallet extends RuntimeException {
    public UserAlreadyCreatedWallet() {
        super(USER_ALREADY_CREATED_WALLET);
    }
}
