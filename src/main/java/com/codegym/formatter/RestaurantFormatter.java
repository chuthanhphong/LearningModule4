package com.codegym.formatter;

import com.codegym.model.Restaurant;
import com.codegym.service.restaurant.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class RestaurantFormatter implements Formatter<Restaurant> {
    IRestaurantService restaurantService;
    @Autowired
    public RestaurantFormatter(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public Restaurant parse(String id, Locale locale) throws ParseException {
        return restaurantService.findById(Long.valueOf(id)).get();
    }

    @Override
    public String print(Restaurant object, Locale locale) {
        return null;
    }
}
