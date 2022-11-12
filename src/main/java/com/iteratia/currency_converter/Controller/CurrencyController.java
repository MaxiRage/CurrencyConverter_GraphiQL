package com.iteratia.currency_converter.Controller;

import com.iteratia.currency_converter.Entity.Currency;
import com.iteratia.currency_converter.Entity.Transactions;
import com.iteratia.currency_converter.Repository.CurrencyRepository;
import com.iteratia.currency_converter.Repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyRepository currencyRepository;
    private final TransactionsRepository transactionsRepository;

    @QueryMapping
    public List<Currency> allCurrency() {
        return currencyRepository.findAll();
    }

    @QueryMapping
    public List<Transactions> allTransactions() {
        return transactionsRepository.findAll();
    }



}