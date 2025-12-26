package com.codewithgj.store.services.user;

import com.codewithgj.store.dtos.ProductSummary;
import com.codewithgj.store.entities.Category;
import com.codewithgj.store.entities.Product;
import com.codewithgj.store.repositories.CategoryRepository;
import com.codewithgj.store.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPersistentService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;

    public void fetchPersisted() {
        //var product = productRepository.findById(1L).orElseThrow();
        var product = Product.builder()
                .name("prod2")
                .price(200.50)
                .description("desc2")
                .build();

        byte id = 1;
        product.setCategory(categoryRepository.findById(id).orElseThrow());
    }

    @Transactional
    public void findProducts() {
        System.out.println(productRepository.findProducts(90.5, 300.5));
    }

    @Transactional
    public void updatePriceByCategory() {
        productRepository.updatePriceByCategory(300.5, (byte)2);
    }

    public void fetchProductsByCategory() {
        var products = productRepository.findByCategory(Category.builder().id((byte)1).build());
        products.forEach(System.out::println);
    }
}
