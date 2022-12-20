package com.netflix.backend.repositories;

import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,String> {
    Optional<WatchHistory> findByVideo(Video video);
}
