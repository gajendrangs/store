package com.codewithgj.store.repositories.specifications;

import com.codewithgj.store.entities.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpec {
    public static Specification<Product> byName(String name) {
        return (Root<Product> root, CriteriaQuery<?> Query, CriteriaBuilder cb) -> cb.like(root.get("name"), "%"+name+"%");
    }

    public static Specification<Product> byPriceGreaterThanOrEqualTo(double minPrice) {
        return (Root<Product> root, CriteriaQuery<?> Query, CriteriaBuilder cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> byPriceLessThanOrEqualTo(double maxPrice) {
        return (Root<Product> root, CriteriaQuery<?> Query, CriteriaBuilder cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
}
