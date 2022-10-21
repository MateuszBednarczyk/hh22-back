package com.zse.hh22.wallet.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public record CreateDriverLicenceDTO(@NotBlank(message = "Picture cannot be null")
                                     @Size(max = 512)
                                     String picture,
                                     @NotBlank(message = "Image of document front cannot be blank")
                                     @Size(max = 512)
                                     String frontOfDocumentImage,
                                     @NotBlank(message = "Image of document back cannot be blank")
                                     @Size(max = 512)
                                     String backOfDocumentImage,
                                     @NotBlank(message = "First name cannot be blank") String firstName,
                                     @Nullable String secondName,
                                     @NotBlank(message = "Surname cannot be blank") String surname,
                                     @NotBlank(message = "Place of birth cannot be blank") String placeOfBirth,
                                     @NotNull(message = "Date of birth cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date birthDate,
                                     @NotEmpty List<DriverLicencePermissionDTO> permissions,
                                     @NotBlank(message = "Document number cannot be blank") String documentNumber,
                                     @NotBlank(message = "Issuing authority cannot be blank") String issuingAuthority,
                                     @NotNull(message = "Date of issue cannot be blank") @JsonFormat(pattern = "yyyy-MM-dd") Date dateOfIssue) {
}
