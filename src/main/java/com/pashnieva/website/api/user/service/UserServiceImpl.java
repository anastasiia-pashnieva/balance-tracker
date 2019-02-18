package com.pashnieva.website.api.user.service;

import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pashnieva.website.api.user.util.UserApiErrorCodes.USER_NOT_FOUND_CODE;
import static com.pashnieva.website.api.user.util.UserApiErrorCodes.USER_NOT_FOUND_MESSAGE;
import static com.pashnieva.website.common.exception.model.ApiException.notFound;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String id) {
        if (userRepository.existsById(id)) {
            return userRepository.getOne(id);
        }
        throw notFound(USER_NOT_FOUND_CODE, USER_NOT_FOUND_MESSAGE);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        throw notFound(USER_NOT_FOUND_CODE, USER_NOT_FOUND_MESSAGE);
    }

    @Override
    public void deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        throw notFound(USER_NOT_FOUND_CODE, USER_NOT_FOUND_MESSAGE);
    }
}
