package com.codeup.springblog.controllers;


import com.codeup.springblog.repositories.UserRepository;

public class UserController {


//    dependency injection
    private final UserRepository usersDao;

    public UserController(UserRepository usersDao) {
        this.usersDao = usersDao;
    }


//    are we not needing this????






}
