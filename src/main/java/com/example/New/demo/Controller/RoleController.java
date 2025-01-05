package com.example.New.demo.Controller;

import com.example.New.demo.Model.Role;
import com.example.New.demo.Model.User;
import com.example.New.demo.Reository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/post")
    public Role insert(@RequestBody Role role) {
        return roleRepo.save(role);
    }

}
