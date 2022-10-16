package com.zse.hh22.wallet.service.identitycard;

import com.zse.hh22.wallet.api.CreateIdentityCardDTO;

import java.security.Principal;

public interface CreateIdentityCardService {
    void createIdentityCard(CreateIdentityCardDTO requestDTO, Principal loggedUser);
}