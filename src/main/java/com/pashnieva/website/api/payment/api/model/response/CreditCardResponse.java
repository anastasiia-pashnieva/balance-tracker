package com.pashnieva.website.api.payment.api.model.response;

import com.pashnieva.website.api.payment.dto.CreditCard;
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
public class CreditCardResponse {

    private String id;
    private String cardName;
    private BigDecimal balance;

    public static CreditCardResponse from(CreditCard creditCard) {
        return Objects.nonNull(creditCard) ? CreditCardResponse
                .builder()
                .id(creditCard.getId())
                .cardName(creditCard.getCardName())
                .balance(creditCard.getCardBalance())
                .build() : null;
    }

    public static List<CreditCardResponse> from(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(CreditCardResponse::from)
                .collect(Collectors.toList());
    }
}
