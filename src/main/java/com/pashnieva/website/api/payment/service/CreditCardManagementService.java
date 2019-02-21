package com.pashnieva.website.api.payment.service;

import com.pashnieva.website.api.payment.dto.CreditCard;

import java.util.List;

public interface CreditCardManagementService {

    CreditCard getCreditCard(String id);
    List<CreditCard> getAllCreditCards();
    CreditCard addCreditCard(CreditCard creditCard);
    CreditCard updateCreditCard(CreditCard creditCard);
    void deleteCreditCard(String id);
}
