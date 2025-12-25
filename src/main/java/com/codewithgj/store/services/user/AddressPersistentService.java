package com.codewithgj.store.services.user;

import com.codewithgj.store.entities.Address;
import com.codewithgj.store.entities.User;
import com.codewithgj.store.repositories.AddressRepository;
import com.codewithgj.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressPersistentService {
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final UserRepository userRepository;

    public void saveAddress(User user) {
        var address = Address.builder()
                .street("street")
                .city("city")
                .zip("123")
                .state("state")
                .id(user.getId())
                .build();
        addressRepository.save(address);
    }

    @Transactional
    public void fetchRelatedObjects() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println("AddressRepository: "+ address.getUser().getEmail());
    }

    @Transactional
    public void removeAddress() {
        Address address = addressRepository.findById(2L).orElseThrow();
        var user = address.getUser();
        user.removeAddress(address);
        userRepository.save(user);
    }
}
