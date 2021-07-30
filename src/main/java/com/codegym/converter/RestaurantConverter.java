package com.codegym.converter;


import org.springframework.core.convert.converter.Converter;

public class RestaurantConverter implements Converter<String,RestaurantConverter> {

    private String restaurantName;

    public RestaurantConverter(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public RestaurantConverter convert(String name) {
        return null;
    }
}
