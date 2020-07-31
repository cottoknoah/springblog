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
    public String postsIndex() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postById(@PathVariable long id) {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateForm() {
        return "view the form for creating a post";
    }

//    connect to the first one but differently?
    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }
}

