package com.y.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void 재고를_초과해서_제품을_빼면_오류(){
        Product product = new Product(1L, "초코바", 1000, 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> product.decreaseStock(5));
    }

    @Test
    void 재고1개에_1개를_더하면_2개(){
        Product product = new Product(2L, "콜라", 1000,  1);

        product = product.increaseStock(1);

        Assertions.assertEquals(2, product.getStock());
    }


}