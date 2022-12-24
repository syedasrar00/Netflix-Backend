package com.netflix.backend.services;

import com.netflix.backend.DTO.OtpDTO;

public interface OtpService {
    String verifyEmail(OtpDTO otpDto);
    String verifyPhone(OtpDTO otpDto);

    String resetPassword(OtpDTO otpdto);

    void sendOtpOnEmail();
    void sendOtpOnPhone();

    String sendOtp(OtpDTO otpDTO);
}
