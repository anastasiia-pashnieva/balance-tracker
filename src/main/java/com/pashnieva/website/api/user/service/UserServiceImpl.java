package com.pashnieva.website.api.user.service;

import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.api.model.request.UpdateUserRequest;
import com.pashnieva.website.api.user.api.model.transformer.UserTransformer;
import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.api.user.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManagementService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserTransformer<CreateUserRequest> createUserRequestTransformer;

    @Autowired
    private UserTransformer<UpdateUserRequest> updateUserRequestTransformer;

    @Override
    public User getUser(String id) {
        userValidator.validateUserId(id);
        return userService.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User createUser(CreateUserRequest request) {
        userValidator.validateCreateUserRequest(request);
        return userService.createUser(createUserRequestTransformer.transform(request));
    }

    @Override
    public User updateUser(UpdateUserRequest request, String userId) {
        userValidator.validateUserId(userId);
        userValidator.validateUpdateUserRequest(request);

        Map<String, Object> userProperties = new HashMap<>();
        userProperties.put("userId", userId);
        return userService.updateUser(updateUserRequestTransformer.transform(request, userProperties));
    }

    @Override
    public void deleteUser(String id) {
        userValidator.validateUserId(id);
        userService.deleteUser(id);
    }
}
