package com.eqlyn.server.repository;

import com.eqlyn.server.entity.Transaction;
import com.eqlyn.server.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccountId(Integer accountId);
}