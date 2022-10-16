package com.zse.hh22.wallet.service.document;

import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.api.CreatePassportDTO;

import java.security.Principal;

public interface CreateDocumentService {
    void createIdentityCard(CreateIdentityCardDTO requestDTO, Principal loggedUser);

    void createPassport(CreatePassportDTO requestDTO, Principal loggedUser);
}