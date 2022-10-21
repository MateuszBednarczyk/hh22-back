package com.zse.hh22.wallet.service.document;

import com.zse.hh22.wallet.domain.document.DocumentEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;

import java.util.List;

public interface FindDocumentService {
    List<DocumentEntity> findAllByDocumentStatus(DocumentStatus documentStatus);
}
