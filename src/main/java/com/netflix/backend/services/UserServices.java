package com.netflix.backend.services;

import com.netflix.backend.DTO.UserDTO;

import java.util.List;

public interface UserServices {
    String createUser(UserDTO userObject);
    String activateSubscription();
    String deactivateSubscription();

}
