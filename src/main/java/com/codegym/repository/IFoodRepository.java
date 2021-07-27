package com.codegym.repository;

import com.codegym.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends PagingAndSortingRepository<Food,Long> {
}
