package com.netflix.backend.repositories;

import com.netflix.backend.entities.Otp;
import com.netflix.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface OtpRepository extends JpaRepository<Otp,String> {
    @Query(value = "SELECT * FROM otp o WHERE o.state = 'unused' AND o.user_id = :userId AND o.otp_number = :otpNumber",
            nativeQuery = true)
    Optional<Otp> findByUserAndOtpNumber(@Param("userId") String userId,
                                         @Param("otpNumber") String otpNumber);
    @Query(value = "SELECT * FROM otp o WHERE o.state = 'unused' AND o.user_id = :userId",
        nativeQuery = true)
    List<Otp> findUnusedByUser(@Param("userId") String userId);
}
