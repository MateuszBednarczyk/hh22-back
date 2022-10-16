package com.zse.hh22.wallet.endpoint;

import com.zse.hh22.wallet.service.wallet.CreateWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
class CreateWalletController {

    private final CreateWalletService createWalletService;

    @PostMapping("/new")
    public ResponseEntity<Void> createWallet(Principal loggedUser) {
        createWalletService.createWallet(loggedUser);
        return ResponseEntity.ok().build();
    }

}
