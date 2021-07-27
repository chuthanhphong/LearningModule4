package com.codegym.repository;

import com.codegym.model.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant,Long> {
}
