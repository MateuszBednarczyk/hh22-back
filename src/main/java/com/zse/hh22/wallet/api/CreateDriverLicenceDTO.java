package com.zse.hh22.wallet.api;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

public record CreateDriverLicenceDTO(@NotBlank(message = "Picture cannot be null") String picture,
                @NotBlank(message = "Image of document front cannot be blank") String frontOfDocumentImage,
                @NotBlank(message = "Image of document back cannot be blank") String backOfDocumentImage,
                @NotBlank(message = "First name cannot be blank") String firstName,
                @Nullable String secondName,
                @NotBlank(message = "Surname cannot be blank") String surname,
                @NotBlank(message = "Place of birth cannot be blank") String placeOfBirth,
                @NotEmpty ArrayList<DriverLicencePermitionDTO> permitions,
                @NotBlank(message = "Document number cannot be blank") String documentNumber,
                @NotBlank(message = "Issuing authority cannot be blank") String issuingAuthority,
                @NotNull(message = "Date of issue cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date dateOfIssue) {
}
