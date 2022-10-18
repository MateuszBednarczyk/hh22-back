package com.zse.hh22.wallet.api;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DriverLicencePermissionDTO(@NotBlank(message = "Permition cannot be null") String driverLicenceType,
        @JsonFormat(pattern = "yyyy-MM-dd") @NotNull(message = "Date cannot be null") Date dateOfIssue) {
}
