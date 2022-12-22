package com.netflix.backend.repositories;

import com.netflix.backend.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> findByUserName(String userName);

    Optional<Token> findByJwt(String jwt);
}
