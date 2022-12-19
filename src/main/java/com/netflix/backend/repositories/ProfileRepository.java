package com.netflix.backend.repositories;

import com.netflix.backend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,String> {
}
