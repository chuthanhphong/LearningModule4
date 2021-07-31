package com.codegym.formatter;

import com.codegym.model.Price;
import com.codegym.service.price.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class PriceFormatter implements Formatter<Price> {
    private IPriceService priceService;
    @Autowired
    public PriceFormatter(IPriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public Price parse(String id, Locale locale) throws ParseException {
        return priceService.findById(Long.valueOf(id)).get();
    }

    @Override
    public String print(Price object, Locale locale) {
        return null;
    }
}
