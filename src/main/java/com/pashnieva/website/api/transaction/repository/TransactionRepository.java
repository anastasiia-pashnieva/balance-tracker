package com.pashnieva.website.api.transaction.repository;

import com.pashnieva.website.api.transaction.dto.Transaction;

import java.util.List;

/*@Repository*/
public interface TransactionRepository /*extends JpaRepository<Transaction, Long>*/ {

    List<Transaction> findByTransactionType(Transaction.TransactionType type);
}
