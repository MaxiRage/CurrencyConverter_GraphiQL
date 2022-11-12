package com.iteratia.currency_converter.Repository;

import com.iteratia.currency_converter.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository <Currency, String> {
    Optional <Currency> findByName (String name);
}