package com.zse.hh22.wallet.api;

import com.zse.hh22.civicproject.api.ImageLinkDTO;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.domain.document.DocumentType;
import com.zse.hh22.wallet.domain.document.Sex;

import java.util.Date;

public record PassportDTO(DocumentStatus documentStatus, DocumentType documentType, ImageLinkDTO picture,
                          String firstName, String secondName, String surname, String nationality,
                          String documentNumber, Date expiryDate, Date birthDate, Sex sex,
                          String placeOfBirth, String pesel, String issuingAuthority, Date dateOfIssue) {
}
