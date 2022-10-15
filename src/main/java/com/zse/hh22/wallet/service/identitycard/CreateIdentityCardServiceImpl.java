package com.zse.hh22.wallet.service.identitycard;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.domain.identitycard.IdentityCard;
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
        loggedUserEntity.getWallet().setIdentityCard(new IdentityCard(requestDTO));
    }
}
