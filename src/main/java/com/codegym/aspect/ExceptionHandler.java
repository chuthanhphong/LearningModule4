package com.codegym.aspect;

import com.codegym.exception.F404Exception;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(F404Exception.class)
    public ModelAndView show404Page(){
        return new ModelAndView("/404");
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ModelAndView showNullPointPage(){
        return new ModelAndView("/null");
    }
}
