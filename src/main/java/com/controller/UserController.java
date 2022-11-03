package com.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/loginPage")
    public ModelAndView login(){
        ModelAndView modelAndView =new ModelAndView("/loginPage");
        modelAndView.addObject("user",getPrincipal());
        return modelAndView;
    }
    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView modelAndView =new ModelAndView("/admin");
        modelAndView.addObject("user",getPrincipal());
        return modelAndView;
    }

    @GetMapping("/homepage")
    public ModelAndView homepage(){
        ModelAndView modelAndView =new ModelAndView("/homepage");
        modelAndView.addObject("user",getPrincipal());
        return modelAndView;
    }

    @GetMapping("/accessDenied")
    public ModelAndView accessDenied(){
        ModelAndView modelAndView =new ModelAndView("/403");
        modelAndView.addObject("user",getPrincipal());
        return modelAndView;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
