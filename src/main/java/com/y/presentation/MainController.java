package com.y.presentation;

import com.y.business.OrderService;
import com.y.business.ProductService;
import com.y.business.POSMoneyService;
import com.y.presentation.dto.Number;
import com.y.presentation.dto.Order;
import com.y.presentation.dto.TransactionResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    private final OrderService orderService;
    private final ProductService productService;
    private final POSMoneyService POSMoneyService;

    public void run() {
        while (true) {
            int choice = this.choice();
            if (choice == 5) {
                return;
            }
            switch (choice) {
                case 1 -> showAllProducts();
                case 2 -> buyProduct();
                case 3 -> sellProduct();
                case 4 -> showWallet();
            }
        }
    }

    private int choice() {
        try {
            Number number = this.inputView.choice();
            return number.number();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return choice();
        }
    }

    private void showAllProducts() {
        String allProducts = productService.getAllProducts();
        this.outputView.showAllProducts(allProducts);
    }

    public void buyProduct() {
        try {
            Order order = this.inputView.buyProduct();
            TransactionResult transactionResult = this.orderService.buyProduct(order.productId(), order.quantity());
            this.outputView.showBuyResult(transactionResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sellProduct() {
        try {
            Order order = this.inputView.sellProduct();
            TransactionResult transactionResult = this.orderService.sellProduct(order.productId(), order.quantity());
            this.outputView.showSellResult(transactionResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private void showWallet() {
        int walletMoney = this.POSMoneyService.getCurrentWallet();
        this.outputView.showWallet(walletMoney);
    }

}
