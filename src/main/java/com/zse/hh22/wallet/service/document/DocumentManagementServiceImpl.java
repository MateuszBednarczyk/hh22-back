package com.zse.hh22.wallet.service.document;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import com.zse.hh22.wallet.api.VerifyDocumentDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentManagementServiceImpl implements DocumentManagementService {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void verifyDocument(VerifyDocumentDTO requestDTO) {
        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(requestDTO.pesel());
        WalletEntity wallet = user.getWallet();
        switch (requestDTO.documentType()) {
            case "PASSPORT" -> wallet.getPassport().setDocumentStatus(DocumentStatus.VERIFIED);
            case "IDENTITY_CARD" -> wallet.getIdentityCard().setDocumentStatus(DocumentStatus.VERIFIED);
            case "DRIVING_LICENSE" -> wallet.getDriverLicence().setDocumentStatus(DocumentStatus.VERIFIED);
            default -> throw new IllegalArgumentException("Document type not supported");
        }
    }
}
