package com.y.business;

import com.y.business.repository.WalletRepository;
import com.y.domain.Wallet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public int getCurrentWallet(){
        Wallet wallet = this.walletRepository.findById(1L);
        return wallet.getMoney();
    }

}
