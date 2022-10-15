package com.zse.hh22.wallet.endpoint;

import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.service.identitycard.CreateIdentityCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/identity-card")
@RequiredArgsConstructor
public class CreateIdentityCardController {

    private final CreateIdentityCardService createIdentityCardService;

    @PostMapping("/new")
    public ResponseEntity<Void> createIdentityCard(@RequestBody CreateIdentityCardDTO requestDTO, Principal loggedUser) {
        createIdentityCardService.createIdentityCard(requestDTO, loggedUser);
        return ResponseEntity.ok().build();
    }

}
