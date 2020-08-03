package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return "view an individual post" + id;
    }
//    posting views to post URL
//    do I addAttributes
    @GetMapping("/posts/{id}/{title}/{body}")
    @ResponseBody
    public String show(@PathVariable long id, @PathVariable String title, @PathVariable String body) {
        return "view an individual post" + id + title + body;
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

//    connect to the first one but differently?
    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "create a new post";
    }
}

