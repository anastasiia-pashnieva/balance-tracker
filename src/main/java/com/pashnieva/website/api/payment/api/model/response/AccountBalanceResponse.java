package com.pashnieva.website.api.payment.api.model.response;

import com.pashnieva.website.api.payment.dto.AccountBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountBalanceResponse {

    private String id;
    private List<CreditCardResponse> creditCards;
    private BigDecimal cashBalance;
    private BigDecimal totalBalance;

    public static AccountBalanceResponse from(AccountBalance accountBalance) {
        return Objects.nonNull(accountBalance) ? AccountBalanceResponse
                .builder()
                .id(accountBalance.getId())
                .creditCards(CreditCardResponse.from(accountBalance.getCreditCards()))
                .cashBalance(accountBalance.getCashBalance())
                .totalBalance(accountBalance.getTotalBalance())
                .build() : null;
    }

    public static List<AccountBalanceResponse> from(List<AccountBalance> accountBalances) {
        return accountBalances
                .stream()
                .map(AccountBalanceResponse::from)
                .collect(Collectors.toList());
    }
}
