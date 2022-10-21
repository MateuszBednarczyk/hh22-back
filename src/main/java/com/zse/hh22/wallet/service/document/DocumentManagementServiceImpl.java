package com.zse.hh22.wallet.service.document;

import com.zse.hh22.wallet.domain.document.DocumentEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentManagementServiceImpl implements DocumentManagementService {

    private final DocumentRepository documentRepository;

    @Override
    public void verifyDocument(Long id) {
        DocumentEntity documentEntity = documentRepository.findDocumentEntityById(id)
                .orElseThrow(() -> new IllegalArgumentException("Document with id " + id + " not found"));
        documentEntity.setDocumentStatus(DocumentStatus.VERIFIED);
    }
}
