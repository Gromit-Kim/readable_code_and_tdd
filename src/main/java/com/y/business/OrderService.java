package com.y.business;

import com.y.business.repository.ProductRepository;
import com.y.business.repository.WalletRepository;
import com.y.domain.Cashier;
import com.y.domain.Product;
import com.y.domain.Receipt;
import com.y.domain.Wallet;
import com.y.presentation.dto.TransactionResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final WalletRepository walletRepository;

    public TransactionResult buyProduct(Long productId, int quantity){
        Product product = productRepository.findById(productId);
        Wallet wallet = walletRepository.findById(1L);

        Cashier cashier = new Cashier();
        Receipt receipt = cashier.buy(product, quantity, wallet);

        walletRepository.save(receipt.getWallet());
        productRepository.save(receipt.getProduct());

        return receipt.toTransactionResult();
    }

    public TransactionResult sellProduct(Long productId, int quantity){
        Product product = productRepository.findById(productId);
        Wallet wallet = walletRepository.findById(1L);

        Cashier cashier = new Cashier();
        Receipt receipt = cashier.sell(product, quantity, wallet);

        walletRepository.save(receipt.getWallet());
        productRepository.save(receipt.getProduct());

        return receipt.toTransactionResult();
    }

}
