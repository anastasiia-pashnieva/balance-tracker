package com.pashnieva.website.api.user.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserRequest {

    private String firstName;

    public CreateUserRequest(@JsonProperty(value = "firstName", required = true) String firstName) {
        this.firstName = firstName;
    }
}
