package com.codeup.springblog;

import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    /*
    This controller should return strings for the
    following routes that describe what will ultimately be there.
    */

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }





}
