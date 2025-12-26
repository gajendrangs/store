package com.codewithgj.store.repositories;

import com.codewithgj.store.dtos.UserSummary;
import com.codewithgj.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
//    @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > :loyaltyPoint order by p.user.email")
//    @EntityGraph(attributePaths = "user")
//    //List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(@Param("loyaltyPoint") int loyaltyPoint);
//    List<UserSummary> findLoyalProfiles(@Param("loyaltyPoint") int loyaltyPoint);
}
