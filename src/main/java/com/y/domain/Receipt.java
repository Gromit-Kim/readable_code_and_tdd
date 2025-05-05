package com.y.domain;

import com.y.presentation.dto.TransactionResult;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class Receipt {
    private final Product product;
    private final POSMoney POSMoney;
    private final int transactionQuantity;

    public int totalAmount(){
        return this.product.getPrice() * this.transactionQuantity;
    }

    public TransactionResult toTransactionResult(){
        return new TransactionResult(
                product.getName(),
                product.getProductId(),
                this.transactionQuantity,
                totalAmount(),
                POSMoney.getMoney()
        );
    }

}
