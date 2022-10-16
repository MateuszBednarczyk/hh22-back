package com.zse.hh22.wallet.service.wallet;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.WalletDTO;
import com.zse.hh22.wallet.mapper.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@Transactional
@RequiredArgsConstructor
class FindWalletServiceImpl implements FindWalletService {

    private final UserDetailsServiceImpl userDetailsService;
    private final WalletMapper walletMapper;

    @Override
    public WalletDTO findWallet(Principal loggedUser) {
        UserEntity userEntity = (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
        if (userEntity.getWallet() == null) {
            return null;
        } else {
            return walletMapper.mapEntityToDTO(userEntity.getWallet());
        }
    }
}

