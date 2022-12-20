package com.netflix.backend.repositories;

import com.netflix.backend.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show,String> {
    @Query(value = "SELECT * FROM Show s WHERE s.show_name LIKE %:name%",
            nativeQuery = true)
    List<Show> findByShowName(@Param("name")String name);
}
