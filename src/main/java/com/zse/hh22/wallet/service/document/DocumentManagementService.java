package com.zse.hh22.wallet.service.document;

import com.zse.hh22.wallet.api.VerifyDocumentDTO;

public interface DocumentManagementService {
    void verifyDocument(VerifyDocumentDTO requestDTO);
}
