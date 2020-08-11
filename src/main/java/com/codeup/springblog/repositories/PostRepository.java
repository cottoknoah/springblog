package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Post type of entity we want to crud, long is the reference type of primary key
public interface PostRepository extends JpaRepository<Post, Long> {


    // derived queries using the JPA query builder...
    Post findByTitle(String title);
    Post findFirstByOrderByTitleAsc();

    // custom examples using the query annotation
    // examples using JPQL / HQL
//    @Query("Select Post AS p from post where p.id like ?1") ???
    @Query("from Post p where p.id like ?1")
    Post getPostById(long id);

    @Query("select title from Post where LENGTH(title) < 10")
    List<String> getPostsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM posts WHERE LENGTH(title) < 10")
    List<String> getPostsOfCertainTitleLengthNative();


}
