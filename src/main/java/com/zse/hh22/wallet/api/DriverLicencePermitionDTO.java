package com.zse.hh22.wallet.api;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DriverLicencePermitionDTO(@NotBlank(message = "Permition cannot be null") String type, @NotNull(message = "Date cannot be null") Date dateOfIssue) {
}
