package ru.barsim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.barsim.service.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("users", userService.getAllUsers());
        modelAndView.setViewName("index");
    ;    return modelAndView;
    }
}
