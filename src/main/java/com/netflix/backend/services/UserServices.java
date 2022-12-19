package com.netflix.backend.services;

import com.netflix.backend.DTO.UserDTO;

import java.util.List;

public interface UserServices {
    String createUser(UserDTO userObject);
    List<UserDTO> userList();

    String activateSubscription();
    String deactivateSubscription();

}
