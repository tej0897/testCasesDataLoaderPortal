package com.dataloaderportal.DataLoaderPortal;

import com.dataloaderportal.DataLoaderPortal.entity.User;
import com.dataloaderportal.DataLoaderPortal.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureMockMvc
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;
    private User user = new User();     //real Object

    @BeforeEach
    public void init(){

        ArrayList<String> userRoles = new ArrayList<String>();
        user.setUserName("kumar@gmail.com");
        user.setUserFirstName("Tejas");
        user.setUserLastName("Kumar");
        user.setUserPassword("abcd@123");
        userRoles.add("Admin");
        userRoles.add("User");

    }

    public void saveUserSuccess() throws Exception{
        // not using native queries in this use-case. If we are testing, we should test the pre-defined functions like findAll, findByID etc.

    }


}
