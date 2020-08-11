package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private UserRepository usersDao;
    private PostRepository postsDao;


    public PostService(UserRepository usersDao, PostRepository postsDao){
        this.usersDao = usersDao;
        this.postsDao = postsDao;
    }

    public List<Post> returnPosts() {
        List<Post> posts = postsDao.findAll();
        return posts;
    }

    public Post returnIndividualPost(long id) {
        Post post = postsDao.getOne(id);
        return post;
    }

    public void createNewPost(Post post, long id) {
        User user = usersDao.getOne(id);
        post.setAuthor(user);
        postsDao.save(post);
    }


}
