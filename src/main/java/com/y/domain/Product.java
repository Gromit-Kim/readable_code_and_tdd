package com.y.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class Product {
    private final Long productId;
    private final String name;
    private final int price;
    private final int stock;


    public Product decreaseStock(int quantity){
        int decreasedStock = this.stock - quantity;
        if(decreasedStock < 0){
            throw new IllegalArgumentException("[오류] 제품 수량이 0개 이상만 가능합니다.");
        }
        return Product.builder()
                .productId(this.productId)
                .name(this.name)
                .price(this.price)
                .stock(decreasedStock)
                .build();
    }

    public Product increaseStock(int quantity){
        int increasedStock = this.stock + quantity;
        return Product.builder()
                .productId(this.productId)
                .name(this.name)
                .price(this.price)
                .stock(increasedStock)
                .build();
    }
}
