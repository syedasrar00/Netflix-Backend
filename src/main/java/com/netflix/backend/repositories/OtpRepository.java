package com.netflix.backend.repositories;

import com.netflix.backend.entities.Otp;
import com.netflix.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,String> {
    Optional<Otp> findByUserAndOtpNumber(User user, String otpNumber);
}
