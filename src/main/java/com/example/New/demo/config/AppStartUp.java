package com.example.New.demo.config;


import com.example.New.demo.Model.Employee;
import com.example.New.demo.Model.Role;
import com.example.New.demo.Model.User;
import com.example.New.demo.Service.RoleService;
import com.example.New.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppStartUp implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        if (userService.findAll().isEmpty()) {
            Role role1 = new Role();
            role1.setName("Admin");

            Role role2 = new Role();
            role2.setName("User");

            roleService.insert(role1);
            roleService.insert(role2);


            Set<Role> adminRole = new HashSet<>();
            adminRole.add(role1);

            Set<Role> userroles = new HashSet<>();
            userroles.add(role2);

            // create users

            User user1 = new User();
            user1.setUsername("Admin");
            user1.setPassword("123");
            user1.setRoles(adminRole);
            userService.insert(user1);

            User user2 = new User();
            user2.setUsername("user");
            user2.setPassword("4444");
            user2.setRoles(userroles);
            userService.insert(user2);


        }
    }
}