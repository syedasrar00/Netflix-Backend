package com.netflix.backend.repositories;

import com.netflix.backend.entities.UserVideoHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserVideoHistoryRepository extends JpaRepository<UserVideoHistory, UUID> {
}
