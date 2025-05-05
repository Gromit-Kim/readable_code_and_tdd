package com.y.presentation;

import com.y.presentation.dto.TransactionResult;

public class OutputView {

    public void showAllProducts(String products){
        System.out.println("제품명     제품ID     가격(1개당) 현재재고");
        System.out.println(products);
    }

    public void showWallet(int money){
        System.out.printf("현재 잔고는 %d원 입니다.\n", money);
    }

    public void showBuyResult(TransactionResult transactionResult){
        System.out.printf("%s(%s) %d개를 구매하여 %d원을 사용했습니다.\n",
                transactionResult.productName(),
                transactionResult.productId(),
                transactionResult.quantity(),
                transactionResult.totalAmount()
        );
        System.out.printf("현재 잔고: %d원\n", transactionResult.currentWalletMoney());
    }

    public void showSellResult(TransactionResult transactionResult){
        System.out.printf("%s(%s) %d개를 판매하여 %d원을 벌었습니다.\n",
                transactionResult.productName(),
                transactionResult.productId(),
                transactionResult.quantity(),
                transactionResult.totalAmount()
        );
        System.out.printf("현재 잔고: %d원\n", transactionResult.currentWalletMoney());
    }

}
