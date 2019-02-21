package com.pashnieva.website.api.payment.service;

import com.pashnieva.website.api.payment.api.model.request.CreateCreditCardRequest;
import com.pashnieva.website.api.payment.api.model.request.UpdateCreditCardRequest;
import com.pashnieva.website.api.payment.api.model.transformer.CreditCardTransformer;
import com.pashnieva.website.api.payment.dto.CreditCard;
import com.pashnieva.website.api.payment.validator.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardManagementService creditCardService;

    @Autowired
    private CreditCardValidator creditCardValidator;

    @Autowired
    private CreditCardTransformer<CreateCreditCardRequest> createCreditCardRequestTransformer;

    @Autowired
    private CreditCardTransformer<UpdateCreditCardRequest> updateCreditCardRequestTransformer;

    @Override
    public CreditCard getCreditCard(String id) {
        creditCardValidator.validateCreditCardId(id);
        return creditCardService.getCreditCard(id);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @Override
    public CreditCard addCreditCard(CreateCreditCardRequest request) {
        creditCardValidator.validateCreateCreditCardRequest(request);
        return creditCardService.addCreditCard(createCreditCardRequestTransformer.transform(request));
    }

    @Override
    public CreditCard updateCreditCard(UpdateCreditCardRequest request, String cardId) {
        creditCardValidator.validateCreditCardId(cardId);
        creditCardValidator.validateUpdateCreditCardRequest(request);

        Map<String, Object> cardProperties = new HashMap<>();
        cardProperties.put("cardId", cardId);
        return creditCardService.updateCreditCard(updateCreditCardRequestTransformer.transform(request, cardProperties));
    }

    @Override
    public void deleteCreditCard(String id) {
        creditCardValidator.validateCreditCardId(id);
        creditCardService.deleteCreditCard(id);
    }
}
