//package com.codegym.controller;
//
//import com.codegym.model.Discount;
//import com.codegym.model.Tag;
//import com.codegym.service.discount.IDiscountService;
//import com.codegym.service.tag.ITagService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//@Controller
//public class DiscountController {
//    @Autowired
//    private IDiscountService discountService;
//    @GetMapping("/create-Discount")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/discount/create");
//        modelAndView.addObject("discount", new Discount());
//        return modelAndView;
//    }
//    @PostMapping("/create-discount")
//    public ModelAndView saveDiscount(@ModelAttribute("discount") Discount discount) {
//        discountService.save(discount);
//        ModelAndView modelAndView = new ModelAndView("/discount/create");
//        modelAndView.addObject("discount", new Discount());
//        modelAndView.addObject("message", "New discount created successfully");
//        return modelAndView;
//    }
//    @GetMapping("/discount")
//    public ModelAndView listTag() {
//        Iterable<Discount> discounts = discountService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/discount/list");
//        modelAndView.addObject("discounts", discounts);
//        return modelAndView;
//    }
//    @GetMapping("/edit-tag/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Discount> discount = discountService.findById(id);
//        if (discount.isPresent()) { // kiểm tra xem dữ liệu có null không
//            ModelAndView modelAndView = new ModelAndView("/discount/edit");
//            modelAndView.addObject("discount", discount.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/edit-tag")
//    public ModelAndView updateDiscount(@ModelAttribute("discount") Discount discount) {
//        discountService.save(discount);
//        ModelAndView modelAndView = new ModelAndView("/discount/edit");
//        modelAndView.addObject("discount", discount);
//        modelAndView.addObject("message", "discount updated successfully");
//        return modelAndView;
//    }
//    @GetMapping("/delete-tag/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Discount> discount = discountService.findById(id);
//        if (discount.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/discount/delete");
//            modelAndView.addObject("discount", discount.get());
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/delete-tag")
//    public String deleteTag(@ModelAttribute("discount") Discount discount) {
//        discountService.delete(discount.getId());
//        return "redirect:discount";
//    }
//}
