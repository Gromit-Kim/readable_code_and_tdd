package com.y.infrastructure;

import com.y.business.repository.ProductRepository;
import com.y.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepositoryImpl implements ProductRepository {

    private static final Map<Long, Product> products = new ConcurrentHashMap<>();

    static {
        products.put(1L, Product.builder().productId(1L)
                .name("Laptop").price(1200000)
                .stock(50)
                .build());

        products.put(2L, Product.builder().productId(2L)
                .name("Smartphone").price(800000)
                .stock(30)
                .build());

        products.put(3L, Product.builder().productId(3L)
                .name("Headphones").price(150000)
                .stock(20)
                .build());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
            return;
        }
        products.put((long) (products.size() + 1), product);
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().toList();
    }

}
