package com.codegym.formatter;

import com.codegym.model.Type;
import com.codegym.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class TypeFormatter implements Formatter<Type> {
    private ITypeService typeService;

    @Autowired
    public TypeFormatter(ITypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type parse(String id, Locale locale) throws ParseException {
        return typeService.findById(Long.valueOf(id)).get();
    }

    @Override
    public String print(Type object, Locale locale) {
        return null;
    }
}
