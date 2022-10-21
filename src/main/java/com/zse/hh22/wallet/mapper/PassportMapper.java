package com.zse.hh22.wallet.mapper;

import com.zse.hh22.wallet.api.PassportDTO;
import com.zse.hh22.wallet.domain.document.PassportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    PassportDTO mapEntityToDTO(PassportEntity passportEntity);
}