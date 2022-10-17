package com.zse.hh22.wallet.exception;

import static com.zse.hh22.wallet.exception.WalletExceptionsFinals.UNSUPPORTED_DOCUMENT_TYPE;

public class UnsupportedDocumentType extends IllegalArgumentException {
    public UnsupportedDocumentType() {
        super(UNSUPPORTED_DOCUMENT_TYPE);
    }
}
