package com.codewithgj.store.repositories;

import com.codewithgj.store.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository{
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Product> fetchProductsByCriteria(String name, double minPrice, double maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if(name != null) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (!Double.isNaN(minPrice)) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (!Double.isNaN(maxPrice)) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        cq.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
