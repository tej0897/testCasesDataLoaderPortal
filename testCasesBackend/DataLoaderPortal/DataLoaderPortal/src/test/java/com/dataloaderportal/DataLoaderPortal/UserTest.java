package com.dataloaderportal.DataLoaderPortal;

import com.dataloaderportal.DataLoaderPortal.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserTest {

    @Test
    public void test01(){
        User userObj = Mockito.mock(User.class);

        when(userObj.getUserName()).thenReturn(null);   // creating the mock Object

        User user = new User();
        String userNewObj = user.setUserName("Tejas");

        String newUser = user.getUserName();

        when(userObj.getUserName()).thenReturn(userNewObj);
        assertEquals(userNewObj, newUser);

    }
}
