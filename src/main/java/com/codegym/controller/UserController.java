package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/User/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveUser(User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/User/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView showListUser() {
        ModelAndView modelAndView = new ModelAndView("/User/list");
      modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-user/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/User/edit");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/User//error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-user")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/User/edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/User/delete");
            modelAndView.addObject("user", user.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/User/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteCustomer(@ModelAttribute("user") User user) {
      userService.delete(user.getId());
        return "redirect:/user/list";
    }
}

