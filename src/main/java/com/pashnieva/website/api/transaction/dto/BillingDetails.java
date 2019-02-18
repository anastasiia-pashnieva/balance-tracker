package com.pashnieva.website.api.transaction.dto;

import com.pashnieva.website.api.payment.dto.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.pashnieva.website.common.util.StringUtils.isNotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingDetails {

    private Long id;
    private PaymentType paymentType;
    private CreditCard creditCard;
    private BigDecimal cash;


    public enum PaymentType {
        CASH, CREDIT_CARD;

        public PaymentType getPaymentType(String name) {
            return isNotBlank(name) ? PaymentType.valueOf(name.toUpperCase()) : null;
        }
    }
}
