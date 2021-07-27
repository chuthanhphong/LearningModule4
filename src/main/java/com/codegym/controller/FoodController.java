package com.codegym.controller;

import com.codegym.model.Food;
import com.codegym.service.food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("/food/list");
        modelAndView.addObject("foods",foodService.findAll());
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/food/create");

        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Food food, @RequestParam MultipartFile file){
        foodService.save(food);
        return "redirect:/foods";

    }


}
