package com.zse.hh22.wallet.endpoint;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zse.hh22.wallet.api.WalletDTO;
import com.zse.hh22.wallet.service.wallet.FindWalletService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
class FindWalletController {

    private final FindWalletService findWalletService;

    @GetMapping
    public ResponseEntity<WalletDTO> findWallet(Principal loggedUser) {
        return ResponseEntity.ok(findWalletService.findWallet(loggedUser));
    }

}
