package com.zse.hh22.wallet.domain.identitycard;

import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.domain.DocumentStatus;
import com.zse.hh22.wallet.domain.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Table(name = "identity_cards")
@Entity
@Data
@NoArgsConstructor
public class IdentityCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private DocumentStatus documentStatus;

    private String imageLink;

    @NotBlank(message = "Names cannot be blank")
    private String firstName;

    @Nullable
    private String secondName;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Nationality cannot be blank")
    private String nationality;

    @NotBlank(message = "Document number cannot be blank")
    private String documentNumber;

    @NotBlank(message = "Expiry date cannot be blank")
    private Date expiryDate;

    @NotBlank(message = "Date of birth cannot be blank")
    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = "Sex cannot be blank")
    private Sex sex;

    @NotBlank(message = "CAN number cannot be blank")
    @Pattern(regexp = "[\\d]{6}")
    private String CAN;

    @NotBlank(message = "Place of birth cannot be blank")
    private String placeOfBirth;

    @NotBlank(message = "Pesel cannot be blank")
    private String pesel;

    @NotBlank(message = "Family names cannot be blank")
    private String familyName;

    @NotBlank(message = "Mother name cannot be blank")
    private String motherName;

    @NotBlank(message = "Father name cannot be blank")
    private String fatherName;

    @NotBlank(message = "Issuing authority cannot be blank")
    private String issuingAuthority;

    @NotBlank(message = "Identity card number cannot be blank")
    private String identityCardNumber;

    @NotBlank(message = "Date of issue cannot be blank")
    private Date dateOfIssue;

    public IdentityCard(CreateIdentityCardDTO requestDTO) {
        this.documentStatus = DocumentStatus.UNVERIFIED;
        this.imageLink = requestDTO.imageLink();
        this.firstName = requestDTO.firstName();
        this.secondName = requestDTO.secondName();
        this.surname = requestDTO.surname();
        this.nationality = requestDTO.nationality();
        this.documentNumber = requestDTO.documentNumber();
        this.expiryDate = requestDTO.expiryDate();
        this.birthDate = requestDTO.birthDate();
        this.sex = Sex.valueOf(requestDTO.sex().toUpperCase());
        this.CAN = requestDTO.CAN();
        this.placeOfBirth = requestDTO.placeOfBirth();
        this.pesel = requestDTO.pesel();
        this.familyName = requestDTO.familyName();
        this.motherName = requestDTO.motherName();
        this.fatherName = requestDTO.fatherName();
        this.issuingAuthority = requestDTO.issuingAuthority();
        this.identityCardNumber = requestDTO.identityCardNumber();
        this.dateOfIssue = requestDTO.dateOfIssue();
    }
}
