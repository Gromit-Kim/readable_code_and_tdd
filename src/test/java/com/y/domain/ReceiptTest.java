package com.y.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReceiptTest {

    @Test
    void 전체_합계를_올바르게_계산한다(){
        POSMoney POSMoney = new POSMoney(1L, 1000);
        Product product = new Product(1L, "초코바", 1000, 0);
        int orderQuantity = 3;

        int excepted = 3000;

        Receipt receipt = new Receipt(product, POSMoney,orderQuantity);
        int result = receipt.totalAmount();

        Assertions.assertEquals(excepted,result);
    }

}