package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.UserDTO;
import com.netflix.backend.entities.User;
import com.netflix.backend.entities.constants.VerificationStatus;
import com.netflix.backend.entities.constants.UserRole;
import com.netflix.backend.entities.constants.UserState;
import com.netflix.backend.exceptions.DuplicateEntryException;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String createUser(UserDTO userObject) {
        if(userRepo.findByEmail(userObject.getEmail()).orElse(null)==null) {
            if(userRepo.findByPhoneNumber(userObject.getPhoneNumber()).orElse(null)==null){
                User user = modelMapper.map(userObject, User.class);
                String password = user.getPassword();
                String encodedPassword = passwordEncoder.encode(password);
                user.setPassword(encodedPassword);
                user.setUserId(UUID.randomUUID().toString());
                user.setUserRole(UserRole.USER);
                user.setUserState(UserState.ACTIVE);
                user.setEmailVerificationStatus(VerificationStatus.UNVERIFIED);
                user.setPhoneVerificationStatus(VerificationStatus.UNVERIFIED);
                userRepo.save(user);
                return "User created Successfully";
            }
            else throw new DuplicateEntryException("Phone number already exists");
        }
        else throw new DuplicateEntryException("Email already exists");
    }

    @Override
    public String activateSubscription() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if (user.getUserRole().equals(UserRole.USER)) {
            user.setUserRole(UserRole.CUSTOMER);
            userRepo.save(user);
            return "Subscription activated successfully";
        }
        return "User is already subscribed";
    }
    @Override
    public String deactivateSubscription() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if (user.getUserRole().equals(UserRole.CUSTOMER)) {
            user.setUserRole(UserRole.USER);
            userRepo.save(user);
            return "Subscription deactivated successfully";
        }
        return "User is already not subscribed";
    }
}
