package com.codewithgj.store.services.user;

import com.codewithgj.store.entities.Profile;
import com.codewithgj.store.repositories.ProfileRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfilePersistentService {
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;

    public void saveProfile() {
        Profile profile = Profile.builder()
                .bio("bio")
                .build();

        profileRepository.save(profile);
    }

    @Transactional
    public void fetchRelatedObjects() {
        var profile = profileRepository.findById(3L).orElseThrow();
        System.out.println("ProfileRepository: "+profile.getUser().getEmail());
    }
}
