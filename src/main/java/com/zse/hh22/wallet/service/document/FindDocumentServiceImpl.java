package com.zse.hh22.wallet.service.document;

import com.zse.hh22.wallet.domain.document.DocumentEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FindDocumentServiceImpl implements FindDocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public List<DocumentEntity> findAllByDocumentStatus(DocumentStatus documentStatus) {
        return documentRepository.findAllByDocumentStatus(documentStatus);
    }
}
