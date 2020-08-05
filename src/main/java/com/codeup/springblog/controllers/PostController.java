package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    // dependency injection
    protected final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String index() {
        ArrayList<Post> myPosts = new ArrayList<>();
        myPosts.add(new Post(2, "Title 2", "dfknlkdajsdlkajslkajsd"));
        myPosts.add(new Post(3, "Title 3", "dfknlkdajsdlkajslkajsd"));
        myPosts.add(new Post(4, "Title 4", "dfknlkdajsdlkajslkajsd"));
        myPosts.add(new Post(5, "Title 5", "dfknlkdajsdlkajslkajsd"));
        return "posts/index";
    }

//    show a post by it's ID
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id, Model model) {
        Post myPost = new Post(id, "Test Title", "Hello World!");
        model.addAttribute("title", myPost.getTitle());
        model.addAttribute("body", myPost.getBody());
        return "posts/show";
    }

//    show post w/ id title or body ?
//    do I addAttributes here?
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


    @GetMapping("posts/delete/{id}")
    public String delete(@PathVariable long id){
        Post deletedPost = new Post(id);
    }

    @GetMapping("/posts/edit/{id}")
    @ResponseBody
    public String edit(@PathVariable long id, Model model) {
        Post editedPost = new Post(id, "Test Edit", "Hello Edit!");
        model.addAttribute("title", editedPost.getTitle());
        model.addAttribute("body", editedPost.getBody());
        return "redirect:/posts/edit";
//        where do i go once its edited? back to posts? or show the same one?
    }



}


