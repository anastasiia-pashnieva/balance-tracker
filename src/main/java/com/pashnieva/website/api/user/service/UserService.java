package com.pashnieva.website.api.user.service;

import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.api.model.request.UpdateUserRequest;
import com.pashnieva.website.api.user.dto.User;

import java.util.List;

public interface UserService {

    User getUser(String id);
    List<User> getAllUsers();
    User createUser(CreateUserRequest request);
    User updateUser(UpdateUserRequest request, String userId);
    void deleteUser(String id);
}
