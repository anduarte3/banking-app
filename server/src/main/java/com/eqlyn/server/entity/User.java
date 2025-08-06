package com.eqlyn.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long accountId;

    public User() {
    }

    public User(Long id,
                String firstName,
                String lastName,
                String email,
                String password,
                Long accountId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountId = accountId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword() {
        this.password = password;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId() {
        this.accountId = accountId;
    }
}
