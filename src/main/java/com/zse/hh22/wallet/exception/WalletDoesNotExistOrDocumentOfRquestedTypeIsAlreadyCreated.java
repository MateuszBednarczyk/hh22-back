package com.zse.hh22.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.zse.hh22.wallet.exception.WalletExceptionsFinals.WALLET_DOES_NOT_EXIST_OR_DOCUMENT_OF_REQUESTED_TYPE_IS_ALREADY_CREATED;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WalletDoesNotExistOrDocumentOfRquestedTypeIsAlreadyCreated extends IllegalArgumentException {
    public WalletDoesNotExistOrDocumentOfRquestedTypeIsAlreadyCreated(){
        super(WALLET_DOES_NOT_EXIST_OR_DOCUMENT_OF_REQUESTED_TYPE_IS_ALREADY_CREATED);
    }
}
