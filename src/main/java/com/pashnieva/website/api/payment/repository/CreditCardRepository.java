package com.pashnieva.website.api.payment.repository;

import com.pashnieva.website.api.payment.dto.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
