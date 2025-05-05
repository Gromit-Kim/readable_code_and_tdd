package com.y.business.repository;

import com.y.domain.Wallet;

public interface WalletRepository {
    Wallet findById(Long id);
    void save(Wallet wallet);
}
