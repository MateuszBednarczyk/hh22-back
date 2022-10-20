package com.zse.hh22.wallet.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zse.hh22.user.api.ImageDTO;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.domain.document.DocumentType;
import com.zse.hh22.wallet.domain.document.Sex;

import java.util.Date;

public record IdentityCardDTO(DocumentStatus documentStatus, DocumentType documentType, ImageDTO picture,
                              ImageDTO frontOfDocumentImage, ImageDTO backOfDocumentImage, String firstName, String secondName, String surname, String nationality,
                              String documentNumber, @JsonFormat(pattern = "yyyy-MM-dd") Date expiryDate, @JsonFormat(pattern = "yyyy-MM-dd") Date birthDate, Sex sex, String CAN,
                              String placeOfBirth, String pesel, String familyName, String motherName,
                              String fatherName, String issuingAuthority, @JsonFormat(pattern = "yyyy-MM-dd") Date dateOfIssue) {
}
