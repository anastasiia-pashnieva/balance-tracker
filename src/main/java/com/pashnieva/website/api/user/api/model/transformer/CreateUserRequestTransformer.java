package com.pashnieva.website.api.user.api.model.transformer;

import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.dto.User;
import org.springframework.stereotype.Component;

@Component
public class CreateUserRequestTransformer implements UserTransformer<CreateUserRequest> {

    @Override
    public User transform(CreateUserRequest source) {
        return User
                .builder()
                .firstName(source.getFirstName())
                .build();
    }
}
