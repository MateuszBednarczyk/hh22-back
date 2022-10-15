package com.zse.hh22.wallet.domain.identitycard;

import com.zse.hh22.wallet.domain.Name;
import com.zse.hh22.wallet.domain.Sex;
import com.zse.hh22.wallet.domain.Surname;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "identity_cards")
@Entity
@Data
@NoArgsConstructor
public class IdentityCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Name> names;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Surname> surnames;

    private String nationality;
    private String documentNumber;
    private Date expiryDate;
    private Date birthDate;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    private String CAN;
    private String placeOfBirth;
    private String pesel;
    private String familyName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Name> parentsNames;

    private String issuingAuthority;
    private String identityCardNumber;
    private Date dateOfIssue;

}
