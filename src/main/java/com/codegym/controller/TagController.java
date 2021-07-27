package com.codegym.controller;

import com.codegym.model.Tag;
import com.codegym.service.tag.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TagController {
    @Autowired
    private ITagService tagService;
    //    @Autowired
//    private IFoodService iFoodService;
    @GetMapping("/create-tag")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/tag/create");
        modelAndView.addObject("tag", new Tag());
        return modelAndView;
    }
    @PostMapping("/create-tag")
    public ModelAndView saveTag(@ModelAttribute("tag") Tag tag) {
        tagService.save(tag);
        ModelAndView modelAndView = new ModelAndView("/tag/create");
        modelAndView.addObject("tag", new Tag());
        modelAndView.addObject("message", "New tag created successfully");
        return modelAndView;
    }
    @GetMapping("/tag")
    public ModelAndView listTag() {
        Iterable<Tag> tags = tagService.findAll();
        ModelAndView modelAndView = new ModelAndView("/tag/list");
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }
    @GetMapping("/edit-tag/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) { // kiểm tra xem dữ liệu có null không
            ModelAndView modelAndView = new ModelAndView("/tag/edit");
            modelAndView.addObject("tag", tag.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-tag")
    public ModelAndView updateTag(@ModelAttribute("tag") Tag tag) {
        tagService.save(tag);
        ModelAndView modelAndView = new ModelAndView("/tag/edit");
        modelAndView.addObject("tag", tag);
        modelAndView.addObject("message", "Tag updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-tag/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/tag/delete");
            modelAndView.addObject("tag", tag.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-tag")
    public String deleteTag(@ModelAttribute("tag") Tag tag) {
        tagService.delete(tag.getId());
        return "redirect:tag";
    }
}
