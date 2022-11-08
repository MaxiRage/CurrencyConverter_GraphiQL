package com.iteratia.currency_converter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface Transactions extends JpaRepository<Currency, BigDecimal> {
}
