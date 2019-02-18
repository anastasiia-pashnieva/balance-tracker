package com.pashnieva.website.api.user.api.model.response;

import com.pashnieva.website.api.payment.api.model.response.AccountBalanceResponse;
import com.pashnieva.website.api.user.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String id;
    private String firstName;
    private AccountBalanceResponse accountBalance;

    public static UserResponse from(User user) {
        return Objects.nonNull(user) ? UserResponse
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .accountBalance(AccountBalanceResponse.from(user.getBalance()))
                .build() : null;
    }

    public static List<UserResponse> from(List<User> users) {
        return users
                .stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());
    }
}
