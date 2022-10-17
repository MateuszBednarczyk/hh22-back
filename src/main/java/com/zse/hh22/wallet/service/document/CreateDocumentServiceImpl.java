package com.zse.hh22.wallet.service.document;

import java.security.Principal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.CreateDriverLicenceDTO;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.api.CreatePassportDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import com.zse.hh22.wallet.domain.document.DriverLicenceEntity;
import com.zse.hh22.wallet.domain.document.IdentityCardEntity;
import com.zse.hh22.wallet.domain.document.PassportEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
class CreateDocumentServiceImpl implements CreateDocumentService {

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

    @Override
    public void createDriverLicence(CreateDriverLicenceDTO requestDTO, Principal loggedUser) {
        UserEntity user = getUserEntity(loggedUser);
        if (WalletEntity.isWalletCreated(user)) {
            DriverLicenceEntity driverLicenceEntity = new DriverLicenceEntity(requestDTO);
            user.getWallet().setDriverLicence(driverLicenceEntity);
        }
    }

    private UserEntity getUserEntity(Principal loggedUser) {
        return (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
    }

}
