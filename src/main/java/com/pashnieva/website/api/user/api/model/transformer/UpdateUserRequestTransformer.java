package com.pashnieva.website.api.user.api.model.transformer;

import com.pashnieva.website.api.user.api.model.request.UpdateUserRequest;
import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateUserRequestTransformer implements UserTransformer<UpdateUserRequest> {

    @Override
    public User transform(UpdateUserRequest source) {
        return User
                .builder()
                .firstName(source.getFirstName())
                .build();
    }

    @Override
    public User transform(UpdateUserRequest source, Map<String, Object> params) {
        User user = transform(source);
        populate(user, params);
        return user;
    }

    private void populate(User user, Map<String, Object> params) {
        String userId = (String) params.get("userId");
        if (StringUtils.isNotBlank(userId)) {
            user.setId(userId);
        }
    }
}
