package com.codegym.controller;

import com.codegym.service.food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    IFoodService foodService;


}
