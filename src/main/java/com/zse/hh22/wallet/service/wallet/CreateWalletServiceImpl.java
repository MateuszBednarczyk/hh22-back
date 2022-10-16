package com.zse.hh22.wallet.service.wallet;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.domain.WalletEntity;
import com.zse.hh22.wallet.exception.UserAlreadyCreatedWallet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@Transactional
@RequiredArgsConstructor
class CreateWalletServiceImpl implements CreateWalletService {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void createWallet(Principal loggedUser) {
        UserEntity userEntity = (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
        if (userEntity.getWallet() == null) {
            WalletEntity walletEntity = new WalletEntity();
            userEntity.setWallet(walletEntity);
        } else {
            throw new UserAlreadyCreatedWallet();
        }
    }
}
