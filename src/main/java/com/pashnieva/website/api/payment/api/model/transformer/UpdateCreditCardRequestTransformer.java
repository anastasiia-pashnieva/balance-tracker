package com.pashnieva.website.api.payment.api.model.transformer;

import com.pashnieva.website.api.payment.api.model.request.UpdateCreditCardRequest;
import com.pashnieva.website.api.payment.dto.CreditCard;
import com.pashnieva.website.common.util.StringUtils;

import java.util.Map;

public class UpdateCreditCardRequestTransformer implements CreditCardTransformer<UpdateCreditCardRequest> {

    @Override
    public CreditCard transform(UpdateCreditCardRequest source) {
        return CreditCard
                .builder()
                .cardName(source.getCardName())
                .cardBalance(source.getCardBalance())
                .build();
    }

    @Override
    public CreditCard transform(UpdateCreditCardRequest source, Map<String, Object> params) {
        CreditCard creditCard = transform(source);
        populate(creditCard, params);
        return creditCard;
    }

    private void populate(CreditCard creditCard, Map<String, Object> params) {
        String cardId = (String) params.get("cardId");
        if (StringUtils.isNotBlank(cardId)) {
            creditCard.setId(cardId);
        }
    }
}
