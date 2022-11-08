package com.iteratia.currency_converter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Currency extends JpaRepository <Currency, String> {
}