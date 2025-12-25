package com.codewithgj.store.services.user;

import com.codewithgj.store.entities.Address;
import com.codewithgj.store.entities.Category;
import com.codewithgj.store.entities.Product;
import com.codewithgj.store.entities.User;
import com.codewithgj.store.repositories.CategoryRepository;
import com.codewithgj.store.repositories.ProductRepository;
import com.codewithgj.store.repositories.ProfileRepository;
import com.codewithgj.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsePersistentService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void displayPersistentState() {
        User user = User.builder()
                .name("Gaja")
                .email("gaja@gmail.com")
                .password("pwd1")
                .build();

        if(entityManager.contains(user))
            System.out.println("State is Persistent");
        else
            System.out.println("State is Transient/Detached");
        userRepository.save(user);
        if(entityManager.contains(user))
            System.out.println("State is Persistent");
        else
            System.out.println("State is Transient/Detached");
    }

    @Transactional
    public User fetchRelatedObjects() {
        var user = userRepository.findById(4L).orElseThrow();
        System.out.println("UserRepository: "+user.getEmail());
        return user;
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Mithun")
                .email("mithun@gmail.com")
                .password("password")
                .build();

        var address = Address.builder()
                .state("state")
                .city("city")
                .zip("zip")
                .street("street")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }

    public void deleteRelated() {
        userRepository.deleteById(3L);
    }

    @Transactional
    public void saveProduct() {
//        var category = Category.builder()
//                .name("Cat 2")
//                .build();

        var product = Product.builder()
                .name("prod3")
                .price(200.50)
                .description("desc3")
                .build();

        product.setCategory(categoryRepository.findById((byte) 2).orElseThrow());
        productRepository.save(product);
    }

    @Transactional
    public void saveWishlist() {
        var user = userRepository.findById(4L).orElseThrow();
        var products = productRepository.findAll();

//        products.forEach(Product product -> {
//            user.addProduct(product);
//        });
        products.forEach(user::addProduct);
        userRepository.save(user);
    }

    public void deleteProduct() {
        productRepository.deleteById(4L);
    }

    @Transactional
    public void fetchUser() {
        System.out.println(userRepository.findByEmail("gaja@gmail.com").orElseThrow());
    }
}
