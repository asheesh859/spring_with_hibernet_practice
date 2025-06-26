package com.demo;

import com.demo.entity.Profile;
import com.demo.entity.User;
import com.demo.repository.ProfileRepository;
import com.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserProfileTesting {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    void SaveUserProfile(){
        Profile profile = new Profile();
        profile.setBio("Full stack developer");

        User user = new User();
        user.setName("Ashu");
        user.setProfile(profile);
        userRepository.save(user);
    }

    @Test
    void deleteUserProfile(){

        userRepository.deleteById(1L);
    }


}
