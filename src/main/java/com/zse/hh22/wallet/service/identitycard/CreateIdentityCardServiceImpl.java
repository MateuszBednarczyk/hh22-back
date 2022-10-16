package com.zse.hh22.wallet.service.identitycard;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import com.zse.hh22.wallet.domain.document.IdentityCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateIdentityCardServiceImpl implements CreateIdentityCardService {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void createIdentityCard(CreateIdentityCardDTO requestDTO, Principal loggedUser) {
        UserEntity loggedUserEntity = (UserEntity) userDetailsService.loadUserByUsername(loggedUser.getName());
        WalletEntity wallet = loggedUserEntity.getWallet();
        if (isWalletCreated(wallet) && isIdentityCardNotCreated(wallet)) {
            wallet.getDocuments().add(new IdentityCard(requestDTO));
        } else {
            throw new IllegalArgumentException("Create wallet first");
        }
    }

    private static boolean isIdentityCardNotCreated(WalletEntity wallet) {
        return !wallet.getDocuments().contains(IdentityCard.class);
    }

    private static boolean isWalletCreated(WalletEntity wallet) {
        return wallet != null;
    }
}
