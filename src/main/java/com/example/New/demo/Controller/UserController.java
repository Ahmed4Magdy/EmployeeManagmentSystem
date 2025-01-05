package com.example.New.demo.Controller;


import com.example.New.demo.Model.User;
import com.example.New.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/post")
    public User insert(@RequestBody User user) {

        return userService.insert(user);
    }




}
