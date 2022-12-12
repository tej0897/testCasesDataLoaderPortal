package com.dataloaderportal.DataLoaderPortal.service;

import com.dataloaderportal.DataLoaderPortal.entity.Role;
import com.dataloaderportal.DataLoaderPortal.entity.User;
import com.dataloaderportal.DataLoaderPortal.repo.RoleRepo;
import com.dataloaderportal.DataLoaderPortal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userModel;

    @Autowired
    private RoleRepo roleModel;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleModel.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleModel.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123@gmail.com");
        adminUser.setUserPassword(getEncodedPassword("admin@password"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
//        adminUser.setRole(adminRoles);
        userModel.save(adminUser);

//        User user = new User();
//        user.setUserName("tej123");
//        user.setUserPassword(getEncodedPassword("tej@123"));
//        user.setUserFirstName("tej");
//        user.setUserLastName("kumar");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userModel.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleModel.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
//        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userModel.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
