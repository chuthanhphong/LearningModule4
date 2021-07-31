package com.codegym.formatter;

import com.codegym.model.Tag;
import com.codegym.service.tag.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class TagFormatter implements Formatter<Tag> {
    ITagService tagService;
    @Autowired
    public TagFormatter(ITagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public Tag parse(String id, Locale locale) throws ParseException {
        return tagService.findById(Long.valueOf(id)).get();
    }

    @Override
    public String print(Tag object, Locale locale) {
        return null;
    }
}
