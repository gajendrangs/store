package com.codewithgj.store.repositories;

import com.codewithgj.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
