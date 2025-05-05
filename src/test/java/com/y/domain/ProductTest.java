package com.y.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void 재고를_초과해서_제품을_빼면_오류(){
        Product product = new Product(1L, "초코바", 1000, 0, 0, 3, 0, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> product.decreaseStock(5));
    }

    @Test
    void 재고1개에_1개를_더하면_2개(){
        Product product = new Product(2L, "콜라", 1000, 0, 0, 1, 0, 0);

        product = product.increaseStock(1);

        Assertions.assertEquals(2, product.getStock());
    }

    @Test
    void L_V_S_D_M이_주어질때_재고량을_올바르게_계산한다(){
        int L = 3, V = 1, S = 2, P = 5, M = 2;
        int excepted = 6;

        Product product = new Product(3L, "오렌지주스", 2000, L, V, S, P, M);
        int result = product.calculateOrderQuantity();

        Assertions.assertEquals(excepted, result);
    }


}