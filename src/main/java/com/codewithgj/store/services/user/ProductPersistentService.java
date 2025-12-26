package com.codewithgj.store.services.user;

import com.codewithgj.store.dtos.ProductSummary;
import com.codewithgj.store.entities.Category;
import com.codewithgj.store.entities.Product;
import com.codewithgj.store.repositories.CategoryRepository;
import com.codewithgj.store.repositories.ProductRepository;
import com.codewithgj.store.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
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

    public void fetchProductsUsingExample() {
        var product = new Product();
        product.setName("prod");

        var matcher = ExampleMatcher.matching()
                .withIgnorePaths("price")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(product1 -> System.out.println(product1.getName()));
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.fetchProductsByCriteria("prod", 1,200);
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecification(String name, double minPrice, double maxPrice) {
        Specification<Product> spec = Specification.unrestricted();

        if (name != null) {
            spec = spec.and(ProductSpec.byName(name));
        }
        if (!Double.isNaN(minPrice)) {
            spec = spec.and(ProductSpec.byPriceGreaterThanOrEqualTo(minPrice));
        }
        if (!Double.isNaN(maxPrice)) {
            spec = spec.and(ProductSpec.byPriceLessThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec).forEach(System.out::println);
    }

    public void fetchProductsSorted() {
        var sort = Sort.by("name").descending().and(Sort.by("price"));
        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchProductsPaginated(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Product> page = productRepository.findAll(pageRequest);

        var products = page.getContent();
        products.forEach(System.out::println);

        var totalPages = page.getTotalPages();
        var totalElements = page.getTotalElements();

        System.out.println("Total pages: "+ totalPages);
        System.out.println("Total elements: "+totalElements);
    }
}
