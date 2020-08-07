package com.codeup.springblog.controllers;

import com.codeup.springblog.services.GreetingSvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceTestController {
    private GreetingSvc greetingSvc;


    public ServiceTestController(GreetingSvc greetingSvc){
        this.greetingSvc = greetingSvc;
    }

    @GetMapping("/morning/{name)")
    @ResponseBody
    public String morningGreeting(@PathVariable String name){
        return greetingSvc.goodMorning(name);
    }

    @GetMapping("/morning/{name)")
    @ResponseBody
    public String afternoonGreeting(@PathVariable String name){
        return greetingSvc.goodAfternoon(name);
    }

    @GetMapping("/morning/{name)")
    @ResponseBody
    public String eveningGreeting(@PathVariable String name){
        return greetingSvc.goodEvening(name);
    }



}
