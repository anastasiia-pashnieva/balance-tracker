package com.pashnieva.website.api.user.validator;

import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.pashnieva.website.api.user.util.UserApiErrorCodes.*;
import static com.pashnieva.website.common.exception.model.ApiException.badRequest;
import static com.pashnieva.website.common.exception.model.ApiException.notFound;
import static com.pashnieva.website.common.util.StringUtils.isNotBlank;

@Component
public class UserValidator {

    private static final String DIGIT_FORMAT = "^\\d+$";
    private static final String USER_NAME_FORMAT = "^[\\p{L} .'-]+$";

    public void validateUserId(String userId) {
        if (!isNotBlank(userId)) {
            throw badRequest(USER_ID_INVALID_CODE, USER_ID_INVALID_MESSAGE);
        }
    }

    public void validateUserItemIsNotNull(User user) {
        if (Objects.isNull(user)) {
            throw notFound(USER_NOT_FOUND_CODE, USER_NOT_FOUND_MESSAGE);
        }
    }

    public void validateCreateUpdateUserRequest(CreateUserRequest createUserRequest) {
        validateName(createUserRequest.getFirstName());
    }

    private void validateName(String name) {
        if (!StringUtils.isNotBlank(name) || !name.matches(USER_NAME_FORMAT)) {
            throw badRequest(USER_NAME_INVALID_CODE, USER_NAME_INVALID_MESSAGE);
        }
    }
}
