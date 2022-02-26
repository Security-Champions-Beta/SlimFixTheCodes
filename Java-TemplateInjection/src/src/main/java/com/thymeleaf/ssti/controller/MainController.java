package com.thymeleaf.ssti.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }

    @RequestMapping(value="/join", method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String join(Model model, @RequestParam("email") String email){

        if(email.contains("@") || email.contains("$(") || email.equals("${}") || email.contains("~{")){
            email = "'"+email+"'";
        }

        model.addAttribute("email", email);

        return "joined";

    }
}
