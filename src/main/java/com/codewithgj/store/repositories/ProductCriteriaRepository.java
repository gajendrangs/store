package com.codewithgj.store.repositories;

import com.codewithgj.store.entities.Product;

import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> fetchProductsByCriteria(String name, double minPrice, double maxPrice);
}
