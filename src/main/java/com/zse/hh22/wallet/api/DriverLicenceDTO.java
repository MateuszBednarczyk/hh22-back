package com.zse.hh22.wallet.api;

import com.zse.hh22.user.api.ImageDTO;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.domain.document.DocumentType;

import java.sql.Date;
import java.util.List;

public record DriverLicenceDTO(DocumentType documentType, DocumentStatus documentStatus, ImageDTO picture, ImageDTO frontOfDocumentImage, ImageDTO backOfDocumentImage, String firstName, String secondName, String surname, String placeOfBirth, Date birthDate,  List<DriverLicencePermitionDTO> permittions, String documentNumber, String issuingAuthority, Date dateOfIssue) {
}