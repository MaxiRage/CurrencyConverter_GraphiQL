package com.iteratia.currency_converter.Service.Impl;

import com.iteratia.currency_converter.Entity.Currency;
import com.iteratia.currency_converter.Entity.Transactions;
import com.iteratia.currency_converter.Repository.CurrencyRepository;
import com.iteratia.currency_converter.Repository.TransactionsRepository;
import com.iteratia.currency_converter.Service.Exchange;
import com.iteratia.currency_converter.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExchangeImpl implements Exchange {

    public final CurrencyRepository currencyRepository;
    public final TransactionsRepository transactionsRepository;

    @Override
    public Double currencyExchange(String nameBefore, String nameAfter, Double volumeSale) throws Exception {

        if (volumeSale <= 0)
            throw new EntityNotFoundException("Не корректные значения обмена");

        Currency currencyNameBefore = currencyRepository.findByName(nameBefore).orElseThrow(() -> new EntityNotFoundException("Валюта не найден"));
        Currency currencyNameAfter = currencyRepository.findByName(nameAfter).orElseThrow(() -> new EntityNotFoundException("Валюта не найден"));

        double currencyValueBefore = Double.parseDouble(String.valueOf(currencyNameBefore.getValue())) / currencyNameBefore.getNominal();
        double currencyValueAfter = Double.parseDouble(String.valueOf(currencyNameAfter.getValue())) / currencyNameAfter.getNominal();

        double result = currencyValueBefore / currencyValueAfter * volumeSale;

        Transactions transactions = new Transactions();

        transactions.setInitialCurrency(currencyNameBefore);
        transactions.setFinalCurrency(currencyNameAfter);
        transactions.setInitialValue(BigDecimal.valueOf(currencyValueBefore));
        transactions.setFinalValue(BigDecimal.valueOf(currencyValueAfter));
        transactions.setRate(BigDecimal.valueOf(currencyValueBefore / currencyValueAfter));
        transactions.setTimestamp(LocalDateTime.now());
        transactions.setVolume(BigDecimal.valueOf(volumeSale));
        transactions.setResult(BigDecimal.valueOf(result));
        transactionsRepository.save(transactions);

        return Math.pow(result, 2);
    }
}
