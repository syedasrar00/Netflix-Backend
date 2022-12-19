package com.netflix.backend.repositories;

import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,Integer> {
    Optional<WatchHistory> findByVideo(Video video);
}
