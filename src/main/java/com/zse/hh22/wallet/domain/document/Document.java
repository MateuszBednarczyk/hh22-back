package com.zse.hh22.wallet.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "documents")
@Entity
@Data
@NoArgsConstructor
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    public DocumentStatus documentStatus;

    @NotBlank(message = "Document number cannot be blank")
    public String documentNumber;

    @NotBlank(message = "Link to image cannot be null")
    public String frontOfDocumentImage;

    @NotBlank(message = "Place of birth cannot be blank")
    public String placeOfBirth;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expiry date cannot be blank")
    public Date expiryDate;

    @NotBlank(message = "Link to image cannot be null")
    public String backOfDocumentImage;

    @NotBlank(message = "Names cannot be blank")
    public String firstName;

    @Nullable
    public String secondName;

    @NotBlank(message = "Surname cannot be blank")
    public String surname;

    @NotBlank(message = "Issuing authority cannot be blank")
    public String issuingAuthority;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date dateOfIssue;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of birth cannot be blank")
    public Date birthDate;
}
