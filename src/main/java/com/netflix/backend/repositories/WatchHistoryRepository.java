package com.netflix.backend.repositories;

import com.netflix.backend.entities.Video;
import com.netflix.backend.entities.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,String> {
    Optional<WatchHistory> findByVideo(Video video);
    @Query(value="SELECT * FROM watch_history WHERE video_id = :videoId AND profile_id = :profileId",
            nativeQuery = true)
    Optional<WatchHistory> findByVideoIdProfileId(@Param("videoId") String videoId,
                                              @Param("profileId") String profileId);
}
