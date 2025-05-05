package com.y.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Wallet {
    private final Long id;
    private final int money;

    public Wallet addMoney(int amount) {
        int addedMoney = this.money + amount;
        return Wallet.builder()
                .money(addedMoney)
                .id(id)
                .build();
    }

    public Wallet minusMoney(int amount) {
        int minusMoney = this.money - amount;
        if (minusMoney <= 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        return Wallet.builder()
                .money(minusMoney)
                .id(id)
                .build();
    }

}
