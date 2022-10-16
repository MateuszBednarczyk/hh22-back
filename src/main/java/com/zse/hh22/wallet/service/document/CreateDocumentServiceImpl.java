package com.zse.hh22.wallet.service.document;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.api.CreatePassportDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import com.zse.hh22.wallet.domain.document.IdentityCardEntity;
import com.zse.hh22.wallet.domain.document.PassportEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateDocumentServiceImpl implements CreateDocumentService {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void createIdentityCard(CreateIdentityCardDTO requestDTO, Principal loggedUser) {
        UserEntity user = getUserEntity(loggedUser);
        if (WalletEntity.isWalletCreated(user)) {
            IdentityCardEntity identityCardEntity = new IdentityCardEntity(requestDTO);
            user.getWallet().setIdentityCard(identityCardEntity);
        }
    }

    @Override
    public void createPassport(CreatePassportDTO requestDTO, Principal loggedUser) {
        UserEntity user = getUserEntity(loggedUser);
        if (WalletEntity.isWalletCreated(user)) {
            PassportEntity passportEntity = new PassportEntity(requestDTO);
            user.getWallet().setPassport(passportEntity);
        }
    }

    private UserEntity getUserEntity(Principal loggedUser) {
        return (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
    }
}
