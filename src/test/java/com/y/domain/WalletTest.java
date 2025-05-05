package com.y.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    void 천원에서_이천원을_빼면_오류가발생한다(){
        Wallet wallet = new Wallet(1L, 1000);

        Assertions.assertThrows(IllegalArgumentException.class,() -> wallet.minusMoney(2000));
    }

    @Test
    void 천원에_천원을_더하면_2000원이된다(){
        Wallet wallet = new Wallet(1L, 1000);

        wallet = wallet.addMoney(1000);

        Assertions.assertEquals(2000, wallet.getMoney());
    }

}