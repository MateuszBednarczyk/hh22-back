package com.zse.hh22.wallet.endpoint;


import com.zse.hh22.wallet.domain.document.DocumentEntity;
import com.zse.hh22.wallet.domain.document.DocumentStatus;
import com.zse.hh22.wallet.service.document.FindDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/documents")
public class FindDocumentController {

    private final FindDocumentService findDocumentService;

    @GetMapping("/verified")
    public List<DocumentEntity> findAllByDocumentStatusVerified(){
        return findDocumentService.findAllByDocumentStatus(DocumentStatus.VERIFIED);
    }

    @GetMapping("/unverified")
    public List<DocumentEntity> findAllByDocumentStatusUnverified(){
        return findDocumentService.findAllByDocumentStatus(DocumentStatus.UNVERIFIED);
    }
}
