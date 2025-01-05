package com.example.New.demo.Service;

import com.example.New.demo.Model.Employee;
import com.example.New.demo.Model.Role;
import com.example.New.demo.Model.User;
import com.example.New.demo.Reository.UserReo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserReo userReo;
    public User insert(User user) {

//        employee.setUser(user);
//        user.setEmployee(employee);
//        System.out.println("User: " + user.getUsername());
//        System.out.println("Employee: " + employee.getName());
        return userReo.save(user);    }

    public User update(User user){

        User current= userReo.findById(user.getId()).orElseThrow();
        current.setUsername(user.getUsername());
        current.setPassword(user.getPassword());
        return userReo.save(current);
    }


    public List<User> findAll() {

        return userReo.findAll();
    }


}
