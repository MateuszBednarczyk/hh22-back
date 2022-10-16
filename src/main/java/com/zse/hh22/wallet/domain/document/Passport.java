package com.zse.hh22.wallet.domain.document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Passport extends Document {

    @NotBlank(message = "Pesel cannot be blank")
    private String pesel;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "Sex cannot be blank")
    private Sex sex;

    @NotBlank(message = "Nationality cannot be blank")
    private String nationality;

}
