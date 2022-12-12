package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.UserObject;
import com.netflix.backend.entities.User;
import com.netflix.backend.repositories.UserRepository;
import com.netflix.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    private UserRepository userRepo;
    @Override
    public String createUser(UserObject userObject) {
        User user = userObjectToUser(userObject);
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

        return "Subscription activated successfully";
    }
    @Override
    public String deactivateSubscription() {

        return "Subscription cancelled successfully";
    }

    private User userObjectToUser(UserObject userObject){
        User user = new User();
        user.setEmail(userObject.getEmail());
        user.setName(userObject.getName());
        user.setPassword(userObject.getPassword());
        user.setPhoneNumber(userObject.getPhoneNumber());
        return user;
    }
    private UserObject userToUserObject(User user){
        UserObject userObject = new UserObject();
        userObject.setEmail(user.getEmail());
        userObject.setName(user.getName());
        userObject.setPassword(user.getPassword());
        userObject.setPhoneNumber(user.getPhoneNumber());
        return userObject;
    }
}
