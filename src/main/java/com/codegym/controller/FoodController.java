package com.codegym.controller;

import com.codegym.model.Food;
import com.codegym.service.discount.IDiscountService;
import com.codegym.service.food.IFoodService;
import com.codegym.service.price.IPriceService;
import com.codegym.service.restaurant.IRestaurantService;
import com.codegym.service.tag.ITagService;
import com.codegym.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/foods")
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
    public ResponseEntity<Food> getAll(){
        List<Food> foods= (List<Food>) foodService.findAll();
        if(foods.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity(foods,HttpStatus.OK);
    }

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("/food/list");
        modelAndView.addObject("foods",foodService.findAll());
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
        foodService.save(food);
        return "redirect:/foods";
    }


}
