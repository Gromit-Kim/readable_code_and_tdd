package com.y.business.repository;

import com.y.domain.Product;
import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    void save(Product product);
    List<Product> findAll();
}
