package com.codegym.controller;

import com.codegym.model.Food;
import com.codegym.service.discount.IDiscountService;
import com.codegym.service.food.IFoodService;
import com.codegym.service.price.IPriceService;
import com.codegym.service.restaurant.IRestaurantService;
import com.codegym.service.tag.ITagService;
import com.codegym.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin("*")
public class FoodController {
    @Autowired
    IFoodService foodService;

    @Autowired
    IRestaurantService restaurantService;

    @Autowired
    IPriceService priceService;

    @Autowired
    ITagService tagService;

    @Autowired
    IDiscountService discountService;

    @Autowired
    ITypeService typeService;

    @GetMapping("/api")

    public ResponseEntity<Iterable<Food>> getAll(){
        Iterable<Food> foods= foodService.findAll();
        return new ResponseEntity(foods,HttpStatus.OK);
    }

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(size = 5 )Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("/food/list");
        modelAndView.addObject("foods",foodService.findAll(pageable));
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/food/create");
        modelAndView.addObject("restaurants",restaurantService.findAll());
        modelAndView.addObject("prices",priceService.findAll());
        modelAndView.addObject("tags",tagService.findAll());
        modelAndView.addObject("discounts",discountService.findAll());
        modelAndView.addObject("types",typeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Food food, @RequestParam MultipartFile file){
        String fileName= file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("/assets/image/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        food.setImage(fileName);
        food.setCreatedDate(LocalDateTime.now());
        food.setModifiedDate(LocalDateTime.now());
        foodService.save(food);
        return "redirect:/foods";
    }
}
