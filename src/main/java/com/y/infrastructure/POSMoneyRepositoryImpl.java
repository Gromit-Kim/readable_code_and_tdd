package com.y.infrastructure;

import com.y.business.repository.POSMoneyRepository;
import com.y.domain.POSMoney;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class POSMoneyRepositoryImpl implements POSMoneyRepository {

    private static final Map<Long, POSMoney> wallets = new ConcurrentHashMap<>();

    static {
        wallets.put(1L, new POSMoney(1L, 100_000));
    }

    @Override
    public POSMoney findById(Long id) {
        return wallets.get(id);
    }

    @Override
    public void save(POSMoney POSMoney) {
        if (wallets.containsKey(POSMoney.getId())) {
            wallets.put(POSMoney.getId(), POSMoney);
            return;
        }
        wallets.put((long) (wallets.size() + 1), POSMoney);
    }
}
