package com.pashnieva.website.api.payment.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateCreditCardRequest {

    private String cardName;
    private BigDecimal cardBalance;

    public UpdateCreditCardRequest(@JsonProperty(value = "cardName", required = true) String cardName,
                                   @JsonProperty(value = "cardBalance", required = true) BigDecimal cardBalance) {
        this.cardName = cardName;
        this.cardBalance = cardBalance;
    }
}
