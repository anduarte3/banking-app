package com.eqlyn.server.controller;

import com.eqlyn.server.entity.Account;
import com.eqlyn.server.entity.Transaction;
import com.eqlyn.server.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
        public ResponseEntity<Transaction> deposit(@RequestBody Transaction request) {
        try {
            Transaction transaction = transactionService.deposit(request.getAccountId(), request.getAmount());
            return ResponseEntity.ok(transaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody Transaction request) {
        try {
            Transaction transaction = transactionService.withdraw(request.getAccountId(), request.getAmount());
            return ResponseEntity.ok(transaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<Account> getBalance(@PathVariable Integer accountId) {
        try {
            Account account = transactionService.getAccountId(accountId);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}