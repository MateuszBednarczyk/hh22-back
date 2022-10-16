package com.zse.hh22.wallet.service.wallet;

import com.zse.hh22.wallet.api.WalletDTO;

import java.security.Principal;

public interface FindWalletService {
    WalletDTO findWallet(Principal loggedUser);
}
