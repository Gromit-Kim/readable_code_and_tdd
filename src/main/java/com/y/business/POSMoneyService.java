package com.y.business;

import com.y.business.repository.POSMoneyRepository;
import com.y.domain.POSMoney;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class POSMoneyService {

    private final POSMoneyRepository POSMoneyRepository;

    public int getCurrentWallet(){
        POSMoney POSMoney = this.POSMoneyRepository.findById(1L);
        return POSMoney.getMoney();
    }

}
