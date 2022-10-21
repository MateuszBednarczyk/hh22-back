package com.zse.hh22.wallet.repository;

import com.zse.hh22.wallet.domain.document.DocumentEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    List<DocumentEntity> findAllByDocumentStatus(DocumentStatus documentStatus);

    Optional<DocumentEntity> findDocumentEntityById(Long id);
}
