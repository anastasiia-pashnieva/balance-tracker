package com.pashnieva.website.api.payment.api.model.transformer;

import com.pashnieva.website.api.payment.api.model.request.CreateCreditCardRequest;
import com.pashnieva.website.api.payment.dto.CreditCard;

import java.util.Map;

public class CreateCreditCardRequestTransformer implements CreditCardTransformer<CreateCreditCardRequest> {

    @Override
    public CreditCard transform(CreateCreditCardRequest source) {
        return CreditCard
                .builder()
                .cardName(source.getCardName())
                .cardBalance(source.getCardBalance())
                .build();
    }

    @Override
    public CreditCard transform(CreateCreditCardRequest source, Map<String, Object> params) {
        return transform(source);
    }
}
