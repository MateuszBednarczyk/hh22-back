package com.zse.hh22.wallet.mapper;

import com.zse.hh22.wallet.api.DriverLicenceDTO;
import com.zse.hh22.wallet.domain.document.DriverLicenceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverLicenceMapper {
    DriverLicenceDTO mapEntityToDTO(DriverLicenceEntity driverLicenceEntity);
}