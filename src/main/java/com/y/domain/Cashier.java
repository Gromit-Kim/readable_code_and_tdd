package com.y.domain;

public class Cashier {

    public Receipt buy(Product product, int quantity, POSMoney POSMoney) {
        int totalPrice = product.getPrice() * quantity;
        POSMoney = POSMoney.minusMoney(totalPrice);
        product = product.increaseStock(quantity);
        return Receipt.builder()
                .product(product)
                .POSMoney(POSMoney)
                .transactionQuantity(quantity)
                .build();

    }

    public Receipt sell(Product product, int quantity, POSMoney POSMoney) {
        int totalPrice = product.getPrice() * quantity;
        product = product.decreaseStock(quantity);
        POSMoney = POSMoney.addMoney(totalPrice);
        return Receipt.builder()
                .product(product)
                .POSMoney(POSMoney)
                .transactionQuantity(quantity)
                .build();
    }

}
