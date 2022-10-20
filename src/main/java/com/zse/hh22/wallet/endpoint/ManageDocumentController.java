package com.zse.hh22.wallet.endpoint;

import com.zse.hh22.wallet.service.document.DocumentManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class ManageDocumentController {

    private final DocumentManagementService documentManagementService;

    @PatchMapping("/verification/{id}")
    public ResponseEntity<Void> verifyDocument(@PathVariable Long id) {
        documentManagementService.verifyDocument(id);
        return ResponseEntity.ok().build();
    }
}
