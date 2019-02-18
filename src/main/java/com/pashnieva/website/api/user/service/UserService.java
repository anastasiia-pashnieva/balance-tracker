package com.pashnieva.website.api.user.service;

import com.pashnieva.website.api.user.dto.User;

import java.util.List;

public interface UserService {

    User getUser(String id);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
}
