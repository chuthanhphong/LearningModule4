package com.codegym.repository;

import com.codegym.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends PagingAndSortingRepository<Food,Long> {
    Page<Food> findAll(Pageable pageable);
    Page<Food> findAllByRestaurantName(String name, Pageable pageable);
}
