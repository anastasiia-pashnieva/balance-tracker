package com.pashnieva.website.api.user.service;

import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.pashnieva.website.api.user.util.UserApiErrorCodes.USER_NOT_FOUND_CODE;
import static com.pashnieva.website.api.user.util.UserApiErrorCodes.USER_NOT_FOUND_MESSAGE;
import static com.pashnieva.website.common.exception.model.ApiException.notFound;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String id) {
        validateUserExists(id);
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        validateUserExists(user.getId());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        validateUserExists(id);
        userRepository.deleteById(id);
    }

    private void validateUserExists(String id) {
        if (!userRepository.existsById(id)) {
            throw notFound(USER_NOT_FOUND_CODE, USER_NOT_FOUND_MESSAGE);
        }
    }
}
