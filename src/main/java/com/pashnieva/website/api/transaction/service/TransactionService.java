package com.pashnieva.website.api.transaction.service;

import com.pashnieva.website.api.transaction.dto.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getTransaction(Long id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByType(Transaction.TransactionType type);
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
