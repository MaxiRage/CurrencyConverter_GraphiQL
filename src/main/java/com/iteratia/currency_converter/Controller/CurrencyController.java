package com.iteratia.currency_converter.Controller;

import com.iteratia.currency_converter.Entity.Currency;
import com.iteratia.currency_converter.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @QueryMapping
    public List<Currency> allCurrency() {
        return currencyRepository.findAll();
    }
}