package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    // dependency injection
    //    instance field / instance property
    protected final PostRepository postsDao;
    //constructor for the above
    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }


//    is this right?
//    private UserRepository usersDao;
//
//    public PostController(UserRepository usersDao) {
//        this.usersDao = usersDao;
//    }


    //confused
    @GetMapping("/posts")
    public String index(Model model){
        List<Post> myPost = postsDao.findAll();
        model.addAttribute("posts", postsDao.findAll());
            return "posts/index";
    }

//    @GetMapping("/posts")
//    public String index() {
//        ArrayList<Post> myPosts = new ArrayList<>();
//        myPosts.add(new Post(2, "Title 2", "dfknlkdajsdlkajslkajsd"));
//        myPosts.add(new Post(3, "Title 3", "dfknlkdajsdlkajslkajsd"));
//        myPosts.add(new Post(4, "Title 4", "dfknlkdajsdlkajslkajsd"));
//        myPosts.add(new Post(5, "Title 5", "dfknlkdajsdlkajslkajsd"));
//        return "posts/index";
//    }

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


    @GetMapping("posts/{id}/delete")
    public String delete(@PathVariable long id){
//        Post deletedPost = postsDao.getOne(id);
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

//    this was mine, doesn't work - why?
//    @GetMapping("/posts/edit/{id}")
//    @ResponseBody
//    public String edit(@PathVariable long id, Model model) {
//        Post editedPost = new Post(id, "Test Edit", "Hello Edit!");
//        model.addAttribute("title", editedPost.getTitle());
//        model.addAttribute("body", editedPost.getBody());
//        return "redirect:/posts/edit";
//        where do i go once its edited? back to posts? or show the same one?
//    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam String title,
                         @RequestParam String body) {
        // update our database with the latest title and body form the edit form
        // get the post from the db to edit
        Post postToEdit = postsDao.getOne(id);

        // set the postToEdit title and body with values/parameters from the request

        postToEdit.setTitle(title);

        postToEdit.setBody(body);

        // save the changes in the database
        postsDao.save(postToEdit);

        // redirect show page for the given post
        return "redirect:/posts/" + id;
    }






}


