package com.pashnieva.website.api.transaction.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl /*implements TransactionService*/ {

    /*@Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByType(Transaction.TransactionType type) {
        return transactionRepository.findByTransactionType(type);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }*/
}
