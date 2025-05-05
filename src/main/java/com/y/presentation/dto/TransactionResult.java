package com.y.presentation.dto;

public record TransactionResult(
        String productName,
        Long productId,
        int quantity,
        int totalAmount,
        int currentWalletMoney
) {
}
