package com.eqlyn.server.service;

import com.eqlyn.server.entity.Account;
import com.eqlyn.server.entity.Transaction;
import com.eqlyn.server.entity.TransactionType;
import com.eqlyn.server.repository.AccountRepository;
import com.eqlyn.server.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Transaction deposit(Integer accountId, Double amount) {
        System.out.println("Processing deposit for account " + accountId + ", amount: " + amount);

        // Validate amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        // Find the account
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }

        Account account = accountOpt.get();

        Double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction(accountId, TransactionType.DEPOSIT, amount);
        Transaction savedTransaction = transactionRepository.save(transaction);

        System.out.println("Deposit successful. New balance: " + newBalance);
        return savedTransaction;
    }

    @Transactional
    public Transaction withdraw(Integer accountId, Double amount) {
        System.out.println("Processing withdrawal for account " + accountId + ", amount: " + amount);

        // Validate amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        // Find the account
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }

        Account account = accountOpt.get();

        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance. Current balance: " + account.getBalance());
        }

        Double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction(accountId, TransactionType.WITHDRAW, amount);
        Transaction savedTransaction = transactionRepository.save(transaction);

        System.out.println("Withdrawal successful. New balance: " + newBalance);
        return savedTransaction;
    }

    public Double getBalance(Integer accountId) {
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }
        return accountOpt.get().getBalance();
    }

    public Account getAccountId(Integer accountId) {
        // Use your repository to find the account by accountId
        return accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}