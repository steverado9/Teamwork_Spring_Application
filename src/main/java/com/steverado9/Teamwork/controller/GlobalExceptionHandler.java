package com.steverado9.Teamwork.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex, Model model) {

        model.addAttribute("errorMessage", "Page not found");
        return "error/404";
    }

}
