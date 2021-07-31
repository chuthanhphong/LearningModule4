package com.codegym.service.food;

import com.codegym.model.Food;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IFoodService extends IGeneralService<Food> {
    Page<Food> findAll(Pageable pageable);
    Page<Food> findAllByRestaurantName(String name, Pageable pageable);
}
