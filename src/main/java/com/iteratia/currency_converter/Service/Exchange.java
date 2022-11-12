package com.iteratia.currency_converter.Service;

public interface Exchange {

    Double currencyExchange (String nameBefore, String nameAfter, Double volumeSale) throws Exception;
}
