package com.y;

import com.y.business.OrderService;
import com.y.business.ProductService;
import com.y.business.POSMoneyService;
import com.y.business.repository.ProductRepository;
import com.y.business.repository.POSMoneyRepository;
import com.y.infrastructure.ProductRepositoryImpl;
import com.y.infrastructure.POSMoneyRepositoryImpl;
import com.y.presentation.InputView;
import com.y.presentation.MainController;
import com.y.presentation.OutputView;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryImpl();
        POSMoneyRepository POSMoneyRepository = new POSMoneyRepositoryImpl();

        OrderService orderService = new OrderService(productRepository, POSMoneyRepository);
        ProductService productService = new ProductService(productRepository);
        POSMoneyService POSMoneyService = new POSMoneyService(POSMoneyRepository);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        MainController mainController = new MainController(
                inputView, outputView,
                orderService, productService, POSMoneyService
        );

        mainController.run();
    }
}