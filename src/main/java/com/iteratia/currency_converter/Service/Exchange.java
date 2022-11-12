package com.iteratia.currency_converter.Service;

import com.iteratia.currency_converter.Entity.Transactions;

public interface Exchange {

    Transactions currencyExchange (String nameBefore, String nameAfter, Double volumeSale) ;
}
