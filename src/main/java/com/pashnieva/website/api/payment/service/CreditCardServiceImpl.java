package com.pashnieva.website.api.payment.service;

import com.pashnieva.website.api.payment.dto.CreditCard;
import com.pashnieva.website.api.payment.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard getCreditCard(String id) {
        return creditCardRepository.getOne(id);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    /*@Override
    public List<CreditCard> getCreditCardsByUser(User user) {
        return creditCardRepository.findByUser(user);
    }*/

    @Override
    @Transactional
    public CreditCard addCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    @Transactional
    public CreditCard updateCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    @Transactional
    public void deleteCreditCard(String id) {
        creditCardRepository.deleteById(id);
    }
}
