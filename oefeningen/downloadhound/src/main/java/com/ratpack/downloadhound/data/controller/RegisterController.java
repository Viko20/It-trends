package com.ratpack.downloadhound.data.controller;

import com.ratpack.downloadhound.data.entity.User;
import com.ratpack.downloadhound.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/base/register" )
    public String displayRegister(Model model){

        model.addAttribute("user", new User());
        return "/base/register";
    }

    @RequestMapping(value = "/base/register/add")
    @PostMapping
    public ModelAndView addUser(Model model, @ModelAttribute("user") User user){

        user.setActive(true);
        user.setType("USER");
        user.setCreateDate(new java.sql.Date(new Date().getTime()));
        if(userService.userExist(user)){
            return new ModelAndView("redirect:/base/register");
        } else {
            userService.upsertUser(user);
            ModelAndView modelAndView = new ModelAndView("redirect:/base/confirm");
            modelAndView.addObject("email", user.getEmail());
            return modelAndView;
        }
    }

    @GetMapping
    @RequestMapping(value = "/base/confirm")
    public String displayConfirm(Model model){
        return "/base/confirm";
    }
}
