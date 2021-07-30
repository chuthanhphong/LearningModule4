package com.codegym.formatter;

import com.codegym.model.Restaurant;
import com.codegym.service.restaurant.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class RestaurantConverter implements Formatter<Restaurant> {
    IRestaurantService restaurantService;
    @Autowired
    public RestaurantConverter(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public Restaurant parse(String name, Locale locale) throws ParseException {
        return restaurantService.findByName(name).get();
    }

    @Override
    public String print(Restaurant object, Locale locale) {
        return null;
    }
}
