package com.iteratia.currency_converter.Repository;

import com.iteratia.currency_converter.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, BigDecimal> {
}
