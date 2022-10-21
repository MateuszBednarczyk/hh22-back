package com.zse.hh22.wallet.mapper;

import com.zse.hh22.wallet.api.WalletDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletDTO mapEntityToDTO(WalletEntity walletEntity);
}
