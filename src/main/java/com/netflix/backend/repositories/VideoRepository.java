package com.netflix.backend.repositories;

import com.netflix.backend.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
