package com.pashnieva.website.api.payment.validator;

import com.pashnieva.website.api.payment.api.model.request.CreateCreditCardRequest;
import com.pashnieva.website.api.payment.api.model.request.UpdateCreditCardRequest;
import com.pashnieva.website.api.payment.dto.CreditCard;
import com.pashnieva.website.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

import static com.pashnieva.website.api.payment.util.CreditCardApiErrorCodes.*;
import static com.pashnieva.website.common.exception.model.ApiException.badRequest;
import static com.pashnieva.website.common.exception.model.ApiException.notFound;
import static com.pashnieva.website.common.util.StringUtils.isNotBlank;

@Component
public class CreditCardValidator {

    private static final String DIGIT_FORMAT = "^\\d+$";
    private static final String CARD_NAME_FORMAT = "^[\\p{L} .'-]+$";

    public void validateCreditCardId(String cardId) {
        if (!isNotBlank(cardId)) {
            throw badRequest(CREDIT_CARD_ID_INVALID_CODE, CREDIT_CARD_ID_INVALID_MESSAGE);
        }
    }

    public void validateCreditCardItemIsNotNull(CreditCard creditCard) {
        if (Objects.isNull(creditCard)) {
            throw notFound(CREDIT_CARD_NOT_FOUND_CODE, CREDIT_CARD_NOT_FOUND_MESSAGE);
        }
    }

    public void validateCreateCreditCardRequest(CreateCreditCardRequest createCreditCardRequest) {
        validateCardName(createCreditCardRequest.getCardName());
        validateBalance(createCreditCardRequest.getCardBalance());
    }

    public void validateUpdateCreditCardRequest(UpdateCreditCardRequest updateCreditCardRequest) {
        validateCardName(updateCreditCardRequest.getCardName());
        validateBalance(updateCreditCardRequest.getCardBalance());
    }

    private void validateCardName(String name) {
        if (!StringUtils.isNotBlank(name) || !name.matches(CARD_NAME_FORMAT)) {
            throw badRequest(CREDIT_CARD_NAME_INVALID_CODE, CREDIT_CARD_NAME_INVALID_MESSAGE);
        }
    }

    private void validateBalance(BigDecimal balance) {
        if (Objects.isNull(balance) || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw badRequest(CREDIT_CARD_BALANCE_INVALID_CODE, CREDIT_CARD_BALANCE_INVALID_MESSAGE);
        }
    }
}
