package com.y.business.repository;

import com.y.domain.POSMoney;

public interface POSMoneyRepository {
    POSMoney findById(Long id);
    void save(POSMoney POSMoney);
}
