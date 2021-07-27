package com.codegym.service.restaurant;

import com.codegym.model.Restaurant;
import com.codegym.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServive implements IRestaurantService {
    @Autowired
    private IRestaurantRepository restaurantRepository;
    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
