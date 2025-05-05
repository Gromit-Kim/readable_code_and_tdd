package com.y.domain;

public class Cashier {

    public Receipt buy(Product product, int quantity, Wallet wallet) {
        int totalPrice = product.getPrice() * quantity;
        wallet = wallet.minusMoney(totalPrice);
        product = product.increaseStock(quantity);
        return Receipt.builder()
                .product(product)
                .wallet(wallet)
                .transactionQuantity(quantity)
                .build();

    }

    public Receipt sell(Product product, int quantity, Wallet wallet) {
        int totalPrice = product.getPrice() * quantity;
        product = product.decreaseStock(quantity);
        wallet = wallet.addMoney(totalPrice);
        return Receipt.builder()
                .product(product)
                .wallet(wallet)
                .transactionQuantity(quantity)
                .build();
    }

}
