package com.y;

import com.y.business.OrderService;
import com.y.business.ProductService;
import com.y.business.WalletService;
import com.y.business.repository.ProductRepository;
import com.y.business.repository.WalletRepository;
import com.y.infrastructure.ProductRepositoryImpl;
import com.y.infrastructure.WalletRepositoryImpl;
import com.y.presentation.InputView;
import com.y.presentation.MainController;
import com.y.presentation.OutputView;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryImpl();
        WalletRepository walletRepository = new WalletRepositoryImpl();

        OrderService orderService = new OrderService(productRepository, walletRepository);
        ProductService productService = new ProductService(productRepository);
        WalletService walletService = new WalletService(walletRepository);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        MainController mainController = new MainController(
                inputView, outputView,
                orderService, productService, walletService
        );

        mainController.run();
    }
}