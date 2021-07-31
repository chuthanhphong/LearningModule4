package com.codegym.controller;

import com.codegym.model.Food;
import com.codegym.model.Restaurant;
import com.codegym.service.discount.IDiscountService;
import com.codegym.service.food.IFoodService;
import com.codegym.service.price.IPriceService;
import com.codegym.service.restaurant.IRestaurantService;
import com.codegym.service.tag.ITagService;
import com.codegym.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

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

    @ModelAttribute("food")
    public Food initFood(){
        return new Food();
    }

    @GetMapping("/api")
    public ResponseEntity<Iterable<Food>> getAll(){
        Iterable<Food> foods= foodService.findAll();
        return new ResponseEntity(foods,HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Food> findById(@PathVariable Long id){
        Optional<Food> food=foodService.findById(id);
        if(!food.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(food.get(),HttpStatus.OK);
    }

    @PostMapping("/api")
    public ResponseEntity<Food> createFoodApi(@RequestBody Food food){
        foodService.save(food);
        return new ResponseEntity<>(food,HttpStatus.CREATED);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Food> updateFoodApi(@PathVariable Long id,@RequestBody Food food){
        Optional<Food> foodOptional=foodService.findById(id);
        if(!foodOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        food.setId(foodOptional.get().getId());
        foodService.save(food);
        return new ResponseEntity<>(food,HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Food> deleteFoodApi(@PathVariable Long id){
        Optional<Food> foodOptional=foodService.findById(id);
        if(!foodOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        foodService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

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

    @GetMapping("/search/{name}")
    public ModelAndView searchByRestaurantName(@PathVariable String name,Pageable pageable){
        Page<Food> foodPage=foodService.findAllByRestaurantName(name,pageable);
        Restaurant restaurant=restaurantService.findByName(name).get();
        ModelAndView modelAndView=new ModelAndView("/food/search-restaurant");
        modelAndView.addObject("foods",foodPage);
        modelAndView.addObject("restaurant",restaurant);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView viewDetail(@PathVariable Long id){
        Optional<Food> food=foodService.findById(id);
        if(!food.isPresent()) throw new NullPointerException();
        ModelAndView modelAndView=new ModelAndView("/food/edit");
        modelAndView.addObject("food",food.get());
        modelAndView.addObject("restaurants",restaurantService.findAll());
        modelAndView.addObject("prices",priceService.findAll());
        modelAndView.addObject("tags",tagService.findAll());
        modelAndView.addObject("discounts",discountService.findAll());
        modelAndView.addObject("types",typeService.findAll());
        return modelAndView;
    }
    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id,@ModelAttribute("food") Food food,  @RequestParam MultipartFile file, BindingResult result){
        String fileName= file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("/assets/image/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        food.setId(id);
        if(!fileName.equals("")) food.setImage(fileName);
        else {
            food.setImage(foodService.findById(id).get().getImage());
        }
        food.setCreatedDate(foodService.findById(id).get().getCreatedDate());
        food.setModifiedDate(LocalDateTime.now());
        foodService.save(food);
        return "redirect:/foods";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Food> foodOptional=foodService.findById(id);
        if(!foodOptional.isPresent()) throw new NullPointerException();
        ModelAndView modelAndView=new ModelAndView("/food/delete");
        modelAndView.addObject("food",foodOptional.get());
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public String deleteFood(@PathVariable Long id){
        foodService.delete(id);
        return "redirect:/foods";
    }


}
