package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    // dependency injection
    //    instance field / instance property
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    
    //constructor for the above
    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    //all posts
    @GetMapping("/posts")
    public String index(Model model){
//        List<Post> myPost = postsDao.findAll();
        model.addAttribute("posts", postsDao.findAll());
            return "posts/index";
    }

//    show a post by it's ID
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post pulledPost = postsDao.getOne(id);
        model.addAttribute("post", pulledPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@RequestParam String title, @RequestParam String body){
        User user = usersDao.getOne(1L);
        Post post = new Post(title, body, user);
        postsDao.save(post);
        return "redirect:/posts";
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

    ////    show post w/ id title or body ?
////    do I addAttributes here?
//    @GetMapping("/posts/{id}/{title}/{body}")
//    @ResponseBody
//    public String show(@PathVariable long id, @PathVariable String title, @PathVariable String body) {
//        return "view an individual post" + id + title + body;
//    }

//    this leads to the create html
//    @GetMapping("/posts/create")
////    @ResponseBody
//    public String create() {
//        return "posts/create";
//    }






}


