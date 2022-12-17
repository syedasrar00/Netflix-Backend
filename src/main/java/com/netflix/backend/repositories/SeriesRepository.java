package com.netflix.backend.repositories;

import com.netflix.backend.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series,Long> {
}
