package com.zse.hh22.wallet.endpoint;

import com.zse.hh22.wallet.api.VerifyDocumentDTO;
import com.zse.hh22.wallet.service.document.DocumentManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class ManageDocumentController {

    private final DocumentManagementService documentManagementService;

    @PatchMapping("/verification")
    public ResponseEntity<Void> verifyDocument(@RequestBody VerifyDocumentDTO verifyDocumentDTO) {
        documentManagementService.verifyDocument(verifyDocumentDTO);
        return ResponseEntity.ok().build();
    }
}
