package com.pashnieva.website.api.ws;

import com.pashnieva.website.api.payment.service.CreditCardService;
import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.api.model.response.UserResponse;
import com.pashnieva.website.api.user.api.model.transformer.UserTransformer;
import com.pashnieva.website.api.user.dto.User;
import com.pashnieva.website.api.user.service.UserService;
import com.pashnieva.website.api.user.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserWS {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserTransformer<CreateUserRequest> transformer;

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") String userId) {
        userValidator.validateUserId(userId);
        User user = userService.getUser(userId);
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody CreateUserRequest createUserRequest) {
        userValidator.validateCreateUpdateUserRequest(createUserRequest);
        User user = userService.createUser(transformer.transform(createUserRequest));
        return ResponseEntity.ok(UserResponse.from(user));
    }
}
