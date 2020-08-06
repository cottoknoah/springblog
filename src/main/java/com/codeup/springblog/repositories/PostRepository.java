package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


    // derived queries using the JPA query builder...
    Ad findByTitle(String title);
    Ad findFirstByOrderByTitleAsc();

    // custom examples using the query annotation
    // examples using JPQL / HQL
    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    @Query("select title from Ad where LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM ads WHERE LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLengthNative();

}

}
