package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String viewloginForm(){
        return "login";
    }

//    @PostMapping("/login")
//    public  String viewLoginInfo(@RequestParam(name = "username")
//    String username, @RequestParam(name = "password") String password, Model model){
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        return "login";
//    }


}
