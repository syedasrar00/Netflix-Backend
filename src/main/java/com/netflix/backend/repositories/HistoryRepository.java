package com.netflix.backend.repositories;

import com.netflix.backend.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query(value = "SELECT * FROM History h WHERE h.video_id = :videoId and h.user_id = :userId",
    nativeQuery = true)
    Optional<History> findByUserAndVideo(
            @Param("videoId") Long videoId,
            @Param("userId") Long userId);
}
