package com.codeup.springblog;


import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class AnotherAdsIntegrationTests {

    private HttpSession httpSession;

//    constructor dependency injection not allowed in tests
//    you have to to use Autowired before injection

     //the actual MVC object the can listen HTTP requests
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AdRepository adsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;




}
