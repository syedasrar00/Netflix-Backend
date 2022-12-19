package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.UserDTO;
import com.netflix.backend.entities.User;
import com.netflix.backend.ENUMS.UserRole;
import com.netflix.backend.ENUMS.UserState;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        User user = modelMapper.map(userObject,User.class);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setUserId(UUID.randomUUID().toString());
        user.setUserRole(UserRole.ROLE_USER);
        user.setUserState(UserState.ACTIVE);
        userRepo.save(user);
        return "User created Successfully";
    }

    @Override
    public List<UserDTO> userList() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(e-> modelMapper.map(e,UserDTO.class)).collect(Collectors.toList());
    }
    @Override
    public String activateSubscription() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setUserRole(UserRole.ROLE_CUSTOMER);
        userRepo.save(user);
        return "Subscription activated successfully";
    }
    @Override
    public String deactivateSubscription() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setUserRole(UserRole.ROLE_USER);
        userRepo.save(user);
        return "Subscription cancelled successfully";
    }
}
