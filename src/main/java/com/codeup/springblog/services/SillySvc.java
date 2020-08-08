package com.codeup.springblog.services;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SillySvc {
    //dependency injection
    private AdRepository adsDao;
    private UserRepository userDao;

    //    constructor
    public SillySvc(AdRepository adsDao, UserRepository userDao) {
        this.adsDao = adsDao;
        this.userDao = userDao;
    }

    //method to grab length of ad description and username
    public int totalPostCharacters() {
//        Java object instead of ArrayList
        Iterable<Ad> ads = adsDao.findAll();
        Iterable<User> users = userDao.findAll();
//        bucket
        int total = 0;
//        looping Ads and adding/assigning to total variable
        for (Ad ad : ads) {
            total += ad.getDescription().length();
        }
        for (User user : users) {
            total += user.getUsername().length();
        }
        return total;
    }

}
