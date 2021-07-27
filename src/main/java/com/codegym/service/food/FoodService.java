package com.codegym.service.food;

import com.codegym.model.Food;
import com.codegym.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService implements IFoodService{

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public Iterable<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
