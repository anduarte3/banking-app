package com.eqlyn.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer accountId;
    private Double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(Double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return this.accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return this.balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account {" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
