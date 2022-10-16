package com.zse.hh22.wallet.endpoint;

import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.api.CreatePassportDTO;
import com.zse.hh22.wallet.service.document.CreateDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/document")
@RequiredArgsConstructor
public class CreateDocumentController {

    private final CreateDocumentService createDocumentService;

    @PostMapping("/identity-card")
    public ResponseEntity<Void> createIdentityCard(@RequestBody CreateIdentityCardDTO requestDTO, Principal loggedUser) {
        createDocumentService.createIdentityCard(requestDTO, loggedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/passport")
    public ResponseEntity<Void> createPassport(@RequestBody CreatePassportDTO requestDTO, Principal loggedUser) {
        createDocumentService.createPassport(requestDTO, loggedUser);
        return ResponseEntity.ok().build();
    }

}
