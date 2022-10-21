package com.zse.hh22.wallet.domain.document;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "driver_licence_permissions")
@NoArgsConstructor
public class DriverLicencePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Enumerated(EnumType.ORDINAL)
    private DriverLicenceType driverLicenceType;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssue;

    public DriverLicencePermission(String driverLicenceType, Date dateOfIssue) {
        this.driverLicenceType = DriverLicenceType.valueOf(driverLicenceType);
        this.dateOfIssue = dateOfIssue;
    }
}
