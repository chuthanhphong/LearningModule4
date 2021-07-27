package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.User.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserService roleService;

    @GetMapping("/")
    public String home() {
        return "/Role/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/Role/login";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/Role/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView register(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/Role/register");
            return modelAndView;
        }
        for (User userFind : userService.findAll()) {
            if (userFind.getUserName().equals(user.getUserName())) {
                ModelAndView modelAndView = new ModelAndView("/Role/register");
                modelAndView.addObject("message", "Tai khoan nay da duoc tao!");
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView("User/list");
        Optional<User> role = roleService.findById((long) 2);
        userService.save(user);
        modelAndView.addObject("user", user);
        return modelAndView;
    }


}
