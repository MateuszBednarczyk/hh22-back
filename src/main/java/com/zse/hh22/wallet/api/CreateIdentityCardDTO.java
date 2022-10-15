package com.zse.hh22.wallet.api;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public record CreateIdentityCardDTO(
        @NotBlank(message = "imageLink cannot be blank") String imageLink,
        @NotBlank(message = "First name cannot be blank") String firstName,
        @Nullable String secondName,
        @NotBlank(message = "Surname cannot be blank") String surname,
        @NotBlank(message = "Nationality cannot be blank") String nationality,
        @NotBlank(message = "Document number cannot be blank") String documentNumber,
        @NotBlank(message = "Expiry date cannot be blank") Date expiryDate,
        @NotBlank(message = "Date of birth cannot be blank") Date birthDate,
        @NotBlank(message = "Sex cannot be blank") String sex,
        @NotBlank(message = "CAN number cannot be blank") String CAN,
        @NotBlank(message = "Place of birth cannot be blank") String placeOfBirth,
        @NotBlank(message = "Pesel cannot be blank") String pesel,
        @NotBlank(message = "Family names cannot be blank") String familyName,
        @NotBlank(message = "Mother name cannot be blank") String motherName,
        @NotBlank(message = "Mother name cannot be blank") String fatherName,
        @NotBlank(message = "Issuing authority cannot be blank") String issuingAuthority,
        @NotBlank(message = "Identity card number cannot be blank") String identityCardNumber,
        @NotBlank(message = "Date of issue cannot be blank") Date dateOfIssue) {
}
