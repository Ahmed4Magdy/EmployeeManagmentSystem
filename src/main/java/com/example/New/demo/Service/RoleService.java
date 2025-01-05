package com.example.New.demo.Service;

import com.example.New.demo.Model.Employee;
import com.example.New.demo.Model.Role;
import com.example.New.demo.Reository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role FindId(@PathVariable Long id) {
        //modify status
        return roleRepo.findById(id).get();

    }


    public List<Role> findAll() {

        return roleRepo.findAll();
    }

    public Role insert(Role role) {
        return roleRepo.save(role);
    }


}
