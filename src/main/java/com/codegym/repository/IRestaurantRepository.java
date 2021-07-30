package com.codegym.repository;

import com.codegym.model.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant,Long> {
    Optional<Restaurant> findByName(String name);
}
