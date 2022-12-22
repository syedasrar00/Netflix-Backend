package com.netflix.backend.repositories;

import com.netflix.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
