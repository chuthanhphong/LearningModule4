package com.codegym.formatter;

import com.codegym.model.Discount;
import com.codegym.service.discount.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class DiscountFormatter implements Formatter<Discount> {
    IDiscountService discountService;

    @Autowired
    public DiscountFormatter(IDiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public Discount parse(String id, Locale locale) throws ParseException {
        return discountService.findById(Long.valueOf(id)).get();
    }

    @Override
    public String print(Discount object, Locale locale) {
        return null;
    }
}
