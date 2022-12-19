package com.netflix.backend.repositories;

import com.netflix.backend.entities.User;
import com.netflix.backend.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String username);
}
