package com.codewithgj.store;

import com.codewithgj.store.entities.*;
import com.codewithgj.store.entities.User;
import com.codewithgj.store.repositories.UserRepository;
import com.codewithgj.store.services.user.*;
import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var userService = context.getBean(UsePersistentService.class);
        userService.fetchByLoyaltyPoints();

//        var profileService = context.getBean(ProfilePersistentService.class);
//        profileService.fetchByLoyaltyPoints();

//        var addressService = context.getBean(AddressPersistentService.class);
//        addressService.removeAddress();

//        var categoryService = context.getBean(CategoryPersistentService.class);
//        categoryService.persistRelated();

//        var productService = context.getBean(ProductPersistentService.class);
//        productService.findProducts();
	}

    public void oldLessons() {
//      ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//        orderService.init();

//        var notificationService = context.getBean(NotificationManager.class);
//        notificationService.sendNotification();
//        context.close();

//        var userService = context.getBean(UserService.class);
//        userService.registerUser(new User(123, "mithu@gmail.com", "mithu123", "Mithun"));
//        userService.registerUser(new User(124, "mikku@gmail.com", "mikku124", "Migali"));

        var user = User.builder()
                .name("GJ")
                .email("gj@gmail.com")
                .password("myPwd!")
                .build();

        var address = Address.builder()
                .street("a")
                .city("b")
                .state("c")
                .zip("123")
                .build();

        user.addAddress(address);

        var tag = new Tag("tag1");
        user.addTag(tag);
        System.out.println(user);

        user.removeTag(tag);
        System.out.println(user);

        var profile = Profile.builder()
                .bio("a")
                .dateOfBirth(LocalDate.now())
                .phoneNumber("123")
                .loyaltyPoints(1)
                .build();

        user.addProfile(profile);
        System.out.println(user);

        user.removeProfile(profile);
        System.out.println(user);

        var category = Category.builder()
                .name("cat1")
                .build();

        var product = Product.builder()
                .name("apple")
                .price(100.00)
                .build();

        category.addProduct(product);
        System.out.println(category);

        user.addProductToWishlist(product);
        System.out.println(user);

        user.removeProductFromWishlist(product);
        System.out.println(user);

//        var userRepository = context.getBean(UserRepository.class);
//        com.codewithgj.store.entities.User user = User.builder()
//                .name("GJ")
//                .email("gj@gmail.com")
//                .password("myPwd!")
//                .build();
//
//        userRepository.save(user);
//        var userObj = userRepository.findById(2L).orElseThrow();
//        System.out.println(userObj.getEmail());
//        userRepository.deleteById(2L);
    }

}
