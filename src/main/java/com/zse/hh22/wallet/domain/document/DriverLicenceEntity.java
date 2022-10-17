package com.zse.hh22.wallet.domain.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zse.hh22.user.domain.Image;
import com.zse.hh22.wallet.api.CreateDriverLicenceDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "driver_licences")
@NoArgsConstructor
public class DriverLicenceEntity extends DocumentEntity {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<DriverLicencePermition> driverPermitions = new ArrayList<>();

    public DriverLicenceEntity(CreateDriverLicenceDTO requestDTO) {
        this.picture = new Image(requestDTO.picture());
        this.frontOfDocumentImage = new Image(requestDTO.frontOfDocumentImage());
        this.backOfDocumentImage = new Image(requestDTO.backOfDocumentImage());
        this.firstName = requestDTO.firstName();
        this.secondName = requestDTO.secondName();
        this.surname = requestDTO.surname();
        this.placeOfBirth = requestDTO.placeOfBirth();
        this.documentNumber = requestDTO.documentNumber();
        this.issuingAuthority = requestDTO.issuingAuthority();
        this.dateOfIssue = requestDTO.dateOfIssue();
        requestDTO.permitions().stream().forEach(permition -> {
            this.driverPermitions.add(new DriverLicencePermition(DriverLicenceType.valueOf(permition.type()), permition.dateOfIssue()));
        });
    }

}
