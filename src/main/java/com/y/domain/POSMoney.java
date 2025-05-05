package com.y.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class POSMoney {
    private final Long id;
    private final int money;

    public POSMoney addMoney(int amount) {
        int addedMoney = this.money + amount;
        return POSMoney.builder()
                .money(addedMoney)
                .id(id)
                .build();
    }

    public POSMoney minusMoney(int amount) {
        int minusMoney = this.money - amount;
        if (minusMoney <= 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        return POSMoney.builder()
                .money(minusMoney)
                .id(id)
                .build();
    }

}
