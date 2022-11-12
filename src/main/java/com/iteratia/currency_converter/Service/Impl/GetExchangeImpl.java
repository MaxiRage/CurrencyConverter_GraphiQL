package com.iteratia.currency_converter.Service.Impl;

import com.iteratia.currency_converter.Entity.Currency;
import com.iteratia.currency_converter.Repository.CurrencyRepository;
import com.iteratia.currency_converter.Service.GetExchange;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GetExchangeImpl implements GetExchange {

    final CurrencyRepository currencyRepository;

    @PostConstruct
    @SneakyThrows
    @Override
    public void getEntityAllExchange() {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp";
        Document document = Jsoup.connect(url).get();
        ArrayList<Element> numCode = document.select("NumCode");
        ArrayList<Element> charCode = document.select("CharCode");
        ArrayList<Element> nominal = document.select("Nominal");
        ArrayList<Element> name = document.select("Name");
        ArrayList<Element> value = document.select("Value");

        for (int i = 0; i < charCode.size(); i++) {
            Currency currency = new Currency();
            currency.setNumCode(Long.parseLong(numCode.get(i).text()));
            currency.setCharCode(charCode.get(i).text());
            currency.setNominal(Long.parseLong(nominal.get(i).text()));
            currency.setName(name.get(i).text());
            currency.setValue(BigDecimal.valueOf(Double.parseDouble(value.get(i).text().replace(',', '.'))));
            currency.setTimestamp(LocalDateTime.now());
            currencyRepository.save(currency);
        }
        Currency rub = new Currency();
        rub.setNumCode(810L);
        rub.setCharCode("RUR");
        rub.setNominal(1L);
        rub.setName("Российский рубль");
        rub.setValue(BigDecimal.valueOf(1));
        rub.setTimestamp(LocalDateTime.now());
        currencyRepository.save(rub);
    }
}