package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.UserObject;
import com.netflix.backend.entities.User;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    Cookie cookie;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String createUser(UserObject userObject) {
        User user = userObjectToUser(userObject);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "User created Successfully";
    }

    @Override
    public List<UserObject> userList() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(e-> userToUserObject(e)).collect(Collectors.toList());
    }
    @Override
    public String activateSubscription() {
        User user = userRepo.findByEmail(cookie.getName()).orElseThrow(()-> new ResourceNotFoundException("user","username",cookie.getName()));
        if(user.getSubscription()==1){
            return "User is already subscribed";
        }
        user.setSubscription(1);
        userRepo.save(user);
        return "Subscription activated successfully";
    }
    @Override
    public String deactivateSubscription() {
        User user = userRepo.findByEmail(cookie.getName()).orElseThrow(()-> new ResourceNotFoundException("user","username",cookie.getName()));
        user.setSubscription(0);
        userRepo.save(user);
        return "Subscription cancelled successfully";
    }

    private User userObjectToUser(UserObject userObject){
        User user = new User();
        user.setEmail(userObject.getEmail());
        user.setName(userObject.getName());
        user.setPassword(userObject.getPassword());
        user.setPhoneNumber(userObject.getPhoneNumber());
        user.setProfiles(userObject.getProfiles());
        return user;
    }
    private UserObject userToUserObject(User user){
        UserObject userObject = new UserObject();
        userObject.setId(user.getId());
        userObject.setEmail(user.getEmail());
        userObject.setName(user.getName());
        userObject.setPassword(user.getPassword());
        userObject.setPhoneNumber(user.getPhoneNumber());
        userObject.setProfiles(user.getProfiles());
        return userObject;
    }
}
