package com.pashnieva.website.api.payment.service;

import com.pashnieva.website.api.payment.api.model.request.CreateCreditCardRequest;
import com.pashnieva.website.api.payment.api.model.request.UpdateCreditCardRequest;
import com.pashnieva.website.api.payment.dto.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard getCreditCard(String id);
    List<CreditCard> getAllCreditCards();
    CreditCard addCreditCard(CreateCreditCardRequest request);
    CreditCard updateCreditCard(UpdateCreditCardRequest request, String cardId);
    void deleteCreditCard(String id);
}
