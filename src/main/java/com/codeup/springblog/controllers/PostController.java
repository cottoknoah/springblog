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
    private final PostRepository postsDao;

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
}

//Instructors work
//
//@Controller
//public class PostController {
//    @GetMapping("/posts")
//    public String index(Model model){
////        creating a list of posts, to be hardcoded in with post records
//        ArrayList<Post> myPosts = new ArrayList<>();
//        myPosts.add(new Post(2,"Title 2", "wqeoiruqowieuroiwueroiuqwer"));
//        myPosts.add(new Post(3,"Title 3", "Ganymeeeeeeeeeeede"));
//        myPosts.add(new Post(4,"Title 4", "wqeoiruqowieuroiwueroiuqwer"));
//
////        sending over the arraylist to iterate through in html
//        model.addAttribute("posts", myPosts);
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String show(@PathVariable long id, Model model){
////        the PathVariable id gets passed into the constructor
//        Post myPost = new Post(id,"Test Title","Hello World!");
//        model.addAttribute("title", myPost.getTitle());
//        model.addAttribute("body", myPost.getBody());
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String create(){
//        return "Here is the form to create a post!";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String insert(){
//        return "Post has been created!";
//    }
//
//
//}
