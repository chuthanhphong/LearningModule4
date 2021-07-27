//package com.codegym.controller;
//
//import com.codegym.model.Tag;
//import com.codegym.model.Type;
//import com.codegym.service.tag.ITagService;
//import com.codegym.service.type.ITypeService;
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
//public class TypeController {
//    @Autowired
//    private ITypeService typeService;
//
//    @GetMapping("/create-type")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/type/create");
//        modelAndView.addObject("type", new Type());
//        return modelAndView;
//    }
//    @PostMapping("/create-type")
//    public ModelAndView saveType(@ModelAttribute("type") Type  type) {
//        typeService.save(type);
//        ModelAndView modelAndView = new ModelAndView("/type/create");
//        modelAndView.addObject("type", new Type());
//        modelAndView.addObject("message", "New type created successfully");
//        return modelAndView;
//    }
//    @GetMapping("/type")
//    public ModelAndView listType() {
//        Iterable<Type> types = typeService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/type/list");
//        modelAndView.addObject("types", types);
//        return modelAndView;
//    }
//    @GetMapping("/edit-type/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Type> type = typeService.findById(id);
//        if (type.isPresent()) { // kiểm tra xem dữ liệu có null không
//            ModelAndView modelAndView = new ModelAndView("/type/edit");
//            modelAndView.addObject("type", type.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/edit-type")
//    public ModelAndView updateType(@ModelAttribute("type") Type type) {
//        typeService.save(type);
//        ModelAndView modelAndView = new ModelAndView("/type/edit");
//        modelAndView.addObject("type", type);
//        modelAndView.addObject("message", "type updated successfully");
//        return modelAndView;
//    }
//    @GetMapping("/delete-type/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Type> type = typeService.findById(id);
//        if (type.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/type/delete");
//            modelAndView.addObject("type", type.get());
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/delete-type")
//    public String deleteType(@ModelAttribute("type") Type type) {
//        typeService.delete(type.getId());
//        return "redirect:type";
//    }
//}
