package com.zse.hh22.wallet.api;

import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.domain.document.DocumentType;
import com.zse.hh22.wallet.domain.document.Sex;

import java.util.Date;

public record IdentityCardDTO(
        DocumentStatus documentStatus,
        DocumentType documentType,
        String imageLink,
        String firstName,
        String secondName,
        String surname,
        String nationality,
        String documentNumber,
        Date expiryDate,
        Date birthDate,
        Sex sex,
        String CAN,
        String placeOfBirth,
        String pesel,
        String familyName,
        String motherName,
        String fatherName,
        String issuingAuthority,
        String identityCardNumber,
        Date dateOfIssue) {
}
