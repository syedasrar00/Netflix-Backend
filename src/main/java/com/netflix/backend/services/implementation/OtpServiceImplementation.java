package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.OtpDTO;
import com.netflix.backend.entities.Otp;
import com.netflix.backend.entities.User;
import com.netflix.backend.entities.constants.VerificationStatus;
import com.netflix.backend.entities.constants.SentTo;
import com.netflix.backend.entities.constants.State;
import com.netflix.backend.exceptions.InvalidCredentialsException;
import com.netflix.backend.repositories.OtpRepository;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.EmailService;
import com.netflix.backend.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OtpServiceImplementation implements OtpService {

    @Autowired
    private OtpRepository otpRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailSender;
    @Override
    public String verifyEmail(OtpDTO otpDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(!(otpDto.getEmail().equals(user.getEmail()))){
            throw new InvalidCredentialsException("Email ID is incorrect");
        }
        Otp otp = otpRepository.findByUserAndOtpNumber(user.getUserId(), otpDto.getOtp()).orElseThrow(()-> new InvalidCredentialsException("Not a valid OTP"));
        if(otp.getSentTo().equals(SentTo.EMAIL)){
            user.setEmailVerificationStatus(VerificationStatus.VERIFIED);
            userRepository.save(user);
            otp.setState(State.USED);
            otpRepository.save(otp);
        }
        else{
            throw new InvalidCredentialsException("Not a valid OTP");
        }

        return "Email verified successfully";
    }

    @Override
    public String verifyPhone(OtpDTO otpDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(!(otpDto.getPhoneNo().equals(user.getPhoneNumber()))){
            throw new InvalidCredentialsException("Phone no incorrect");
        }
        Otp otp = otpRepository.findByUserAndOtpNumber(user.getUserId(), otpDto.getOtp()).orElseThrow(()-> new InvalidCredentialsException("Not a valid OTP"));
        if(otp.getSentTo().equals(SentTo.PHONE)){
            user.setPhoneVerificationStatus(VerificationStatus.VERIFIED);
            userRepository.save(user);
            otp.setState(State.USED);
            otpRepository.save(otp);
        }
        else{
            throw new InvalidCredentialsException("Not a valid OTP");
        }

        return "Phone verified successfully";
    }

    @Override
    public String resetPassword(OtpDTO otpDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(!(otpDto.getEmail().equals(user.getEmail()))){
            throw new InvalidCredentialsException("Incorrect Email");
        }
        Otp otp = otpRepository.findByUserAndOtpNumber(user.getUserId(), otpDto.getOtp()).orElseThrow(()->new InvalidCredentialsException("OTP incorrect"));
        if(otp.getSentTo().equals(SentTo.EMAIL)){
            user.setPassword(passwordEncoder.encode(otpDto.getPassword()));
            userRepository.save(user);
            otp.setState(State.USED);
            otpRepository.save(otp);
        }
        else{
            throw new InvalidCredentialsException("Not a valid OTP");
        }
        return "Password reset successfully";
    }

    @Override
    public void sendOtpOnEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(user.getEmailVerificationStatus().equals(VerificationStatus.VERIFIED))
            throw new InvalidCredentialsException("email is already verified!");
        List<Otp> otps = otpRepository.findUnusedByUser(user.getUserId());
        otps.stream().forEach(e-> {
            if(e.getSentTo().equals(SentTo.EMAIL)){
                e.setState(State.EXPIRED);
                otpRepository.save(e);
            }
        });
        Otp otp = new Otp();
        otp.setOtpId(UUID.randomUUID().toString());
        otp.setState(State.UNUSED);
        otp.setCreatedAt(new Date());
        otp.setUser(user);
        otp.setSentTo(SentTo.EMAIL);
        int otpNum = (int) ((Math.random()*899999)+100000);
        System.out.println(otpNum);
        otp.setOtpNumber(otpNum+"");
        otpRepository.save(otp);
        emailSender.sendSimpleMail(user.getEmail(), "OTP",otp.getOtpNumber());
    }
}
