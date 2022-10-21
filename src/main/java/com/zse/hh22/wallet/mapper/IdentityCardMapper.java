package com.zse.hh22.wallet.mapper;

import com.zse.hh22.wallet.api.IdentityCardDTO;
import com.zse.hh22.wallet.domain.document.IdentityCardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdentityCardMapper {
    IdentityCardDTO mapEntityToDTO(IdentityCardEntity identityCardEntity);
}
