package com.demo.repository;

import com.demo.entity.Profile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile ,  Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Profile p SET p.bio = :bio WHERE p.id = :id")
    int updateBioById(@Param("id") Long id, @Param("bio") String bio);
}
