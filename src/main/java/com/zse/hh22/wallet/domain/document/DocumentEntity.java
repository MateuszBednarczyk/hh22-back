package com.zse.hh22.wallet.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zse.hh22.user.domain.Image;
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
public abstract class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    public DocumentStatus documentStatus;

    @Enumerated(EnumType.ORDINAL)
    public DocumentType documentType;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @NotNull(message = "Picture cannot be blank")
    public Image picture;

    @NotBlank(message = "Names cannot be blank")
    public String firstName;

    @Nullable
    public String secondName;

    @NotBlank(message = "Surname cannot be blank")
    public String surname;

    @NotBlank(message = "Document number cannot be blank")
    public String documentNumber;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @NotNull(message = "Link to image cannot be null")
    public Image frontOfDocumentImage;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @NotNull(message = "Link to image cannot be null")
    public Image backOfDocumentImage;

    @NotBlank(message = "Place of birth cannot be blank")
    public String placeOfBirth;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of birth cannot be blank")
    public Date birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expiry date cannot be blank")
    public Date expiryDate;

    @NotBlank(message = "Issuing authority cannot be blank")
    public String issuingAuthority;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date dateOfIssue;

}
