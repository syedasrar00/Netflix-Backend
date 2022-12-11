package com.netflix.backend.services;

import com.netflix.backend.DTO.UserObject;
import com.netflix.backend.entities.User;

import java.util.List;

public interface UserServices {
    String createUser(UserObject userObject);
    List<UserObject> userList();

}
