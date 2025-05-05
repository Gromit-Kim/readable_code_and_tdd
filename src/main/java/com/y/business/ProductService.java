package com.y.business;

import com.y.business.repository.ProductRepository;
import com.y.domain.Product;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
    }

}
