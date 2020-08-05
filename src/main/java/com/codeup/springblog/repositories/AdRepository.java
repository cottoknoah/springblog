package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;


// Ad is the reference type of the entity to CRUD
// Long is the reference type for the primary key of Ad
public interface AdRepository extends JpaRepository<Ad, Long> {
        Ad findByTitle(String title); // select * from ads where title = ?
        Ad findFirstByTitle(String title); // select * from ads where title = ? limit 1


    //  examples using JPQL /HQL
    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
//    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from Ad a where a.title like %:term%")
//    List<Ad> searchByTitleLike(@Param("term") String term);

//    @Query("select title from Ad where LENGTH(title) < 10")
//    List<String> getAdsOfCertainTitleLength();
}