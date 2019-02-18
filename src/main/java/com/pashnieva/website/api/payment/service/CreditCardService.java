package com.pashnieva.website.api.payment.service;

import com.pashnieva.website.api.payment.dto.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard getCreditCard(String id);
    List<CreditCard> getAllCreditCards();
    /*List<CreditCard> getCreditCardsByUser(User user);*/
    CreditCard addCreditCard(CreditCard creditCard);
    CreditCard updateCreditCard(CreditCard creditCard);
    void deleteCreditCard(String id);
}
