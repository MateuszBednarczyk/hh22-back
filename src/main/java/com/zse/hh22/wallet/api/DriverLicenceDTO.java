package com.zse.hh22.wallet.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zse.hh22.user.api.ImageDTO;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.domain.document.DocumentType;

import java.sql.Date;
import java.util.List;

public record DriverLicenceDTO(DocumentType documentType, DocumentStatus documentStatus, ImageDTO picture, ImageDTO frontOfDocumentImage, ImageDTO backOfDocumentImage, String firstName, String secondName, String surname, String placeOfBirth, @JsonFormat(pattern = "yyyy-MM-dd") Date birthDate, List<DriverLicencePermissionDTO> permissions, String documentNumber, String issuingAuthority, @JsonFormat(pattern = "yyyy-MM-dd") Date dateOfIssue) {
}