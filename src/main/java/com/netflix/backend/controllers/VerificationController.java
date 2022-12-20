package com.netflix.backend.controllers;

import com.netflix.backend.DTO.OtpDTO;
import com.netflix.backend.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {
    @Autowired
    private OtpService otpService;
    @PostMapping("/user/Email")
    public ResponseEntity<String> verifyEmail(@RequestBody OtpDTO otpDTO){
        return new ResponseEntity<>(otpService.verifyEmail(otpDTO), HttpStatus.OK);
    }
    @PostMapping("/user/phoneNo")
    public ResponseEntity<String> verifyPhone(@RequestBody OtpDTO otpDTO){
        return new ResponseEntity<>(otpService.verifyPhone(otpDTO), HttpStatus.OK);
    }
    @PostMapping("/user/password")
    public ResponseEntity<String> resetPassword(@RequestBody OtpDTO otpDTO){
        otpService.sendOtp();
        return new ResponseEntity<>(otpService.resetPassword(otpDTO), HttpStatus.OK);
    }
    @GetMapping("/user/email/otp")
    public ResponseEntity<Void> sendOtp(){
        otpService.sendOtp();
        return ResponseEntity.ok().build();
    }
}
