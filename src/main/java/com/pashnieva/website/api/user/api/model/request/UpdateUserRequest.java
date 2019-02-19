package com.pashnieva.website.api.user.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateUserRequest {

    private String firstName;

    public UpdateUserRequest(@JsonProperty(value = "firstName", required = true) String firstName) {
        this.firstName = firstName;
    }
}
