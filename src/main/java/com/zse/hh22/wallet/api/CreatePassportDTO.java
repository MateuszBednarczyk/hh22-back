package com.zse.hh22.wallet.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public record CreatePassportDTO(@NotBlank(message = "Image cannot be blank")
                                @Size(max = 512)
                                String picture,
                                @NotBlank(message = "Image link cannot be blank")
                                @Size(max = 512)
                                String frontOfDocumentImage,
                                @NotBlank(message = "Image link cannot be blank")
                                @Size(max = 512)
                                String backOfDocumentImage,
                                @NotBlank(message = "First name cannot be blank") String firstName,
                                @Nullable String secondName,
                                @NotBlank(message = "Surname cannot be blank") String surname,
                                @NotBlank(message = "Nationality cannot be blank") String nationality,
                                @NotBlank(message = "Document number cannot be blank") String documentNumber,
                                @NotNull(message = "Expiry date cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date expiryDate,
                                @NotNull(message = "Date of birth cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date birthDate,
                                @NotBlank(message = "Sex cannot be blank") String sex,
                                @NotBlank(message = "Place of birth cannot be blank") String placeOfBirth,
                                @NotBlank(message = "Pesel cannot be blank") String pesel,
                                @NotBlank(message = "Issuing authority cannot be blank") String issuingAuthority,
                                @NotNull(message = "Date of issue cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date dateOfIssue) {
}
