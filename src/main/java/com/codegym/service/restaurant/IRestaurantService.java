package com.codegym.service.restaurant;

import com.codegym.model.Restaurant;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IRestaurantService extends IGeneralService<Restaurant> {
    Optional<Restaurant> findByName(String name);
}
