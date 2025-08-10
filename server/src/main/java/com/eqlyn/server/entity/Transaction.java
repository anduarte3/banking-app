package com.eqlyn.server.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer accountId;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Double amount;

    public Transaction() {
    }

    public Transaction(Integer accountId, TransactionType transactionType, Double amount) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Integer getTransactionId() {
        return id;
    }
    public void setTransactionId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public TransactionType getTransaction() {
        return transactionType;
    }
    public void setTransaction(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + id +
                ", accountId=" + accountId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                '}';
    }
}