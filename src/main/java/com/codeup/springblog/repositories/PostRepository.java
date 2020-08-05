package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

//    injection goes here -- why?

//    Implement the edit and delete functionality using forms to
//    submit these requests using @PostMapping annotations.

}
