package com.zse.hh22.wallet.domain.document;

import com.zse.hh22.user.domain.Image;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.api.CreatePassportDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "passports")
@Data
@Entity
@NoArgsConstructor
public class PassportEntity extends DocumentEntity {

    @NotBlank(message = "Pesel cannot be blank")
    private String pesel;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "Sex cannot be blank")
    private Sex sex;

    @NotBlank(message = "Nationality cannot be blank")
    private String nationality;

    public PassportEntity(CreatePassportDTO requestDTO) {
        this.documentStatus = DocumentStatus.UNVERIFIED;
        this.documentType = DocumentType.PASSPORT;
        this.picture = new Image(requestDTO.picture());
        this.frontOfDocumentImage = new Image(requestDTO.frontOfDocumentImage());
        this.backOfDocumentImage = new Image(requestDTO.backOfDocumentImage());
        this.firstName = requestDTO.firstName();
        this.secondName = requestDTO.secondName();
        this.surname = requestDTO.surname();
        this.nationality = requestDTO.nationality();
        this.documentNumber = requestDTO.documentNumber();
        this.expiryDate = requestDTO.expiryDate();
        this.birthDate = requestDTO.birthDate();
        this.sex = Sex.valueOf(requestDTO.sex().toUpperCase());
        this.placeOfBirth = requestDTO.placeOfBirth().toUpperCase();
        this.pesel = requestDTO.pesel();
        this.issuingAuthority = requestDTO.issuingAuthority();
        this.dateOfIssue = requestDTO.dateOfIssue();
    }

}
