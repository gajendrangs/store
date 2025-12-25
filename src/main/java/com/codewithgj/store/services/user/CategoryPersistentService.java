package com.codewithgj.store.services.user;

import com.codewithgj.store.entities.Category;
import com.codewithgj.store.entities.Product;
import com.codewithgj.store.repositories.CategoryRepository;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryPersistentService {

    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;

    @Transactional
    public void persistRelated() {
        var product = Product.builder()
                .name("prod2")
                .price(200.50)
                .description("desc2")
                .build();

//        var category = Category.builder()
//                .name("cat1")
//                .build();
        byte id = 1;
        var category = categoryRepository.findById(id).orElseThrow();

        category.addProduct(product);
        categoryRepository.save(category);
    }
}
