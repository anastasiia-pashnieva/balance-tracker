package com.pashnieva.website.api.ws;

import com.pashnieva.website.api.payment.service.CreditCardService;
import com.pashnieva.website.api.user.api.model.request.CreateUserRequest;
import com.pashnieva.website.api.user.api.model.request.UpdateUserRequest;
import com.pashnieva.website.api.user.api.model.response.UserResponse;
import com.pashnieva.website.api.user.api.model.transformer.UserTransformer;
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
    private UserTransformer<CreateUserRequest> createUserRequestTransformer;

    @Autowired
    private UserTransformer<UpdateUserRequest> updateUserRequestTransformer;

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(UserResponse.from(userService.getUser(userId)));
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(UserResponse.from(userService.createUser(createUserRequest)));
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateUser(@PathVariable("userId") String userId, @RequestBody UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(UserResponse.from(userService.updateUser(updateUserRequest, userId)));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
