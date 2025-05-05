package com.y.infrastructure;

import com.y.business.repository.WalletRepository;
import com.y.domain.Wallet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletRepositoryImpl implements WalletRepository {

    private static final Map<Long, Wallet> wallets = new ConcurrentHashMap<>();

    static {
        wallets.put(1L, new Wallet(1L, 100_000));
    }

    @Override
    public Wallet findById(Long id) {
        return wallets.get(id);
    }

    @Override
    public void save(Wallet wallet) {
        if (wallets.containsKey(wallet.getId())) {
            wallets.put(wallet.getId(), wallet);
            return;
        }
        wallets.put((long) (wallets.size() + 1), wallet);
    }
}
