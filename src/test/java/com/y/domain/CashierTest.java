package com.y.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CashierTest {

    @Test
    void 구매시_지갑잔액이모자라면_오류(){
        Wallet wallet = new Wallet(1L, 1000);
        Product product = new Product(1L, "초코바", 500, 0, 0, 10, 0, 1);

        Cashier cashier = new Cashier();

        Assertions.assertThrows(IllegalArgumentException.class, () -> cashier.buy(product, 3, wallet));
    }

    @Test
    void 판매시_제품수량이모자라면_오류(){
        Wallet wallet = new Wallet(1L, 1000);
        Product product = new Product(1L, "테스트상품명", 500, 0, 0, 2, 0, 0);

        Cashier cashier = new Cashier();

        Assertions.assertThrows(IllegalArgumentException.class, () -> cashier.sell(product, 3, wallet));
    }

    @Test
    void 구매_올바른처리(){
        Wallet wallet = new Wallet(1L, 5000);
        Product product = new Product(1L, "초코바", 500, 0, 0, 10, 0, 1);

        Cashier cashier = new Cashier();
        Receipt receipt = cashier.buy(product, 5, wallet);

        Assertions.assertEquals(2500, receipt.getWallet().getMoney());
        Assertions.assertEquals(15, receipt.getProduct().getStock());
    }

    @Test
    void 판매_올바른처리(){
        Wallet wallet = new Wallet(1L, 5000);
        Product product = new Product(1L, "초코바", 500, 0, 0, 10, 0, 1);

        Cashier cashier = new Cashier();
        Receipt receipt = cashier.sell(product, 3, wallet);

        Assertions.assertEquals(6500, receipt.getWallet().getMoney());
        Assertions.assertEquals(7, receipt.getProduct().getStock());
    }

}