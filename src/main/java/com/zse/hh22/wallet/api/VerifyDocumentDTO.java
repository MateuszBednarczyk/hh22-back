package com.zse.hh22.wallet.api;

import javax.validation.constraints.NotBlank;

public record VerifyDocumentDTO(@NotBlank(message = "Pesel cannot be blank") String pesel, @NotBlank(message = "Document type cannot be null") String documentType) {
}
